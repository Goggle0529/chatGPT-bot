package org.example.chatbot.api.domain.zsxq;

import org.example.chatbot.api.domain.zsxq.model.aggregation.UnansweredQuestionsAggregates;

import java.io.IOException;

/**
 * 知识星球Api接口
 */
public interface IZsxqApi {

    UnansweredQuestionsAggregates queryUnansweredQuestionsTopicId(String groupId, String cookie ) throws IOException;

    boolean answer(String group, String cookie, String topicId, String text, boolean silenced) throws IOException;

}
