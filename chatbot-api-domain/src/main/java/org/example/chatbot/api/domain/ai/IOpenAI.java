package org.example.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * chatGPT Open AI 接口: https://platform.openai.com/account/api-keys
 */
public interface IOpenAI {

    String doChatGPT(String question) throws IOException;

}
