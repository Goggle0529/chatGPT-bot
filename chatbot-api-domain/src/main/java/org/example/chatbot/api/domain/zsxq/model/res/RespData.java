package org.example.chatbot.api.domain.zsxq.model.res;

import org.example.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * 请求的结果数据
 */
public class RespData {

    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
