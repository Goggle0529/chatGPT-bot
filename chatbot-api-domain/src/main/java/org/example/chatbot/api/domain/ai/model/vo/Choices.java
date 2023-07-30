package org.example.chatbot.api.domain.ai.model.vo;

/**
 * 选择
 */
public class Choices {

    private String text;

    private int index;

    private Message message;

    private String logprobs;

    private String finish_reason;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(String logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    @Override
    public String toString() {
        return "Choices{" +
                "text='" + text + '\'' +
                ", index=" + index +
                ", message='" + message + '\'' +
                ", logprobs='" + logprobs + '\'' +
                ", finish_reason='" + finish_reason + '\'' +
                '}';
    }
}
