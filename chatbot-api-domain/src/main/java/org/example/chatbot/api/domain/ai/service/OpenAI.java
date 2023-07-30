package org.example.chatbot.api.domain.ai.service;


import org.example.chatbot.api.domain.ai.IOpenAI;
import org.example.chatbot.api.domain.ai.model.aggregates.AIAnswer;
import org.example.chatbot.api.domain.ai.model.vo.Choices;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OpenAI implements IOpenAI {

    private Logger logger = LoggerFactory.getLogger(OpenAI.class);

    @Value("${chatGPT-bot.openAIKey}")
    private String openAIKey;

    @Override
    public String doChatGPT(String question) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + openAIKey);

        String paramJson = "{\n" +
                "     \"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"" + question + "\"}],\n" +
                "     \"temperature\": 0\n" +
                "   }";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
//            logger.info("jsonStr: {}", jsonStr);
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
//            logger.info("aiAnswer: {}", aiAnswer.toString());
            StringBuilder answers = new StringBuilder();
            List<Choices> choices = aiAnswer.getChoices();
//            logger.info("choices: {}", choices);
            for (Choices choice : choices) {
                answers.append(choice.getMessage().getContent());
            }
//            logger.info("answers: {}", answers);
            return answers.toString();
        } else {
            throw new RuntimeException("api.openai.com Err Code is " + response.getStatusLine().getStatusCode());
        }
    }


}
