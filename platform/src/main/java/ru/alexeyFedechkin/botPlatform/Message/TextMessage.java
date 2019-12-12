package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import lombok.NonNull;

/**
 * text message presentation
 * @author fedechkin_alexey
 */
public class TextMessage implements Message {

    public TextMessage(@NonNull String message, @NonNull long chatId){
        this.message = message;
        this.chatId = chatId;
    }

    @Getter
    private String message;
    @Getter
    private long chatId;

    /**
     * @return this object with modified text field
     */
    public TextMessage reply(String message){
        this.message = message;
        return this;
    }
}
