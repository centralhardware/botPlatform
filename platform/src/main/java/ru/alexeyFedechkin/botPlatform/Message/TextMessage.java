package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;

/**
 * @author fedechkin_alexey
 */
public class TextMessage implements Message {

    public TextMessage(String message, long chatId){
        this.message = message;
        this.chatId = chatId;
    }

    @Getter
    private String message;
    @Getter
    private long chatId;
}
