package org.example.chatbot.api.test;

import com.alibaba.fastjson.JSON;
import org.example.chatbot.api.domain.ai.IOpenAI;
import org.example.chatbot.api.domain.ai.service.OpenAI;
import org.example.chatbot.api.domain.zsxq.IZsxqApi;
import org.example.chatbot.api.domain.zsxq.model.aggregation.UnansweredQuestionsAggregates;
import org.example.chatbot.api.domain.zsxq.model.vo.Topics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatGPT-bot.groupId}")
    private String groupId;

    @Value("${chatGPT-bot.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException {
        UnansweredQuestionsAggregates unansweredQuestionsAggregates = zsxqApi.queryUnansweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unansweredQuestionsAggregates));

        List<Topics> topics = unansweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId：{} text：{}", topicId, text);

//            zsxqApi.answer(groupId, cookie, topicId, "下一个问题！", false);
        }
    }

    @Test
    public void test_openai() throws IOException {
        String response = openAI.doChatGPT("帮我写一个堆排序");
        logger.info("测试结果：{}", response);
    }

}
