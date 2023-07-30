package org.example.chatbot.api.test;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void queryUnansweredQuestions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48884228584818/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie", "abtest_env=product; zsxqsessionid=f38d5bc75cc83ee4dcaf044ee7168155; zsxq_access_token=66DFFC21-11E6-F4A4-E158-10E2C208155A_BED79F3539F002BA; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22182224245151522%22%2C%22first_id%22%3A%2218969aa81a816ea-03a75d9ef00e9bc-26031d51-1821369-18969aa81a9198f%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5NjlhYTgxYTgxNmVhLTAzYTc1ZDllZjAwZTliYy0yNjAzMWQ1MS0xODIxMzY5LTE4OTY5YWE4MWE5MTk4ZiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4MjIyNDI0NTE1MTUyMiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22182224245151522%22%7D%2C%22%24device_id%22%3A%2218969aa81a816ea-03a75d9ef00e9bc-26031d51-1821369-18969aa81a9198f%22%7D");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/588124554125284/answer");
        post.addHeader("cookie", "abtest_env=product; zsxqsessionid=f38d5bc75cc83ee4dcaf044ee7168155; zsxq_access_token=66DFFC21-11E6-F4A4-E158-10E2C208155A_BED79F3539F002BA; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22182224245151522%22%2C%22first_id%22%3A%2218969aa81a816ea-03a75d9ef00e9bc-26031d51-1821369-18969aa81a9198f%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5NjlhYTgxYTgxNmVhLTAzYTc1ZDllZjAwZTliYy0yNjAzMWQ1MS0xODIxMzY5LTE4OTY5YWE4MWE5MTk4ZiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4MjIyNDI0NTE1MTUyMiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22182224245151522%22%7D%2C%22%24device_id%22%3A%2218969aa81a816ea-03a75d9ef00e9bc-26031d51-1821369-18969aa81a9198f%22%7D");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    //TODO 请求返回429，意思是请求次数过多。但是并没有。回头再试试
    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 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");

        String paramJson = "{\n" +
                "     \"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"Say this is a test!\"}],\n" +
                "     \"temperature\": 0.7\n" +
                "   }";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
