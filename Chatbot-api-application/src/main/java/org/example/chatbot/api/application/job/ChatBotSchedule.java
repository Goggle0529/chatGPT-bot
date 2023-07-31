package org.example.chatbot.api.application.job;

import com.alibaba.fastjson.JSON;
import org.example.chatbot.api.domain.ai.IOpenAI;
import org.example.chatbot.api.domain.zsxq.IZsxqApi;
import org.example.chatbot.api.domain.zsxq.model.aggregation.UnansweredQuestionsAggregates;
import org.example.chatbot.api.domain.zsxq.model.vo.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * 问答任务
 */
@EnableScheduling
@Configuration
public class ChatBotSchedule {

    private Logger logger = LoggerFactory.getLogger(ChatBotSchedule.class);

    @Value("${chatGPT-bot.groupId}")
    private String groupId;

    @Value("${chatGPT-bot.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;

    /**
     * 定时任务。轮询操作访问网站
     * cron.qqe2.com  可以配置如下cron的值。自定义轮询时间间隔
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        try {
            // 随机一个布尔值，以防访问过于规律导致封控
            if (new Random().nextBoolean()) {
                logger.info("随机打烊中。。。。");
                return;
            }

            // 在空闲时间不工作
            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > 22 || hour < 7) {
                logger.info("打烊时间不工作，AI下班了！");
            }

            // 1.检索问题
            UnansweredQuestionsAggregates unansweredQuestionsAggregates = zsxqApi.queryUnansweredQuestionsTopicId(groupId, cookie);
            logger.info("检索结果： {}", JSON.toJSONString(unansweredQuestionsAggregates));
            List<Topics> topics = unansweredQuestionsAggregates.getResp_data().getTopics();
            if (topics == null || topics.isEmpty()) {
                logger.info("本次检索未查询到待回答问题");
                return;
            }

            // 2、AI回答
            Topics topic = topics.get(0);
            String answer = openAI.doChatGPT(topic.getQuestion().getText().trim());

            // 3.问题回复
            boolean status = zsxqApi.answer(groupId, cookie, topic.getTopic_id(), answer, false);
            logger.info("编号：{} 问题：{} 回答：{} 状态：{}", topic.getTopic_id(), topic.getQuestion().getText(), answer, status);
        } catch (Exception e) {
            logger.info("自动回答问题异常", e);
        }
    }

}
