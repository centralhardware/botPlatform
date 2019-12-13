package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * text message presentation
 * @author fedechkin_alexey
 */
@NoArgsConstructor
public class TextMessage implements Message {

    public TextMessage(@NonNull Integer messageId, @NonNull String message, @NonNull Integer chatId) {
        this.messageId = messageId;
        this.message = message;
        this.chatId = chatId;
    }

    public TextMessage(@NonNull Integer messageId, @NonNull String message, @NonNull Long chatId) {
        this.messageId = messageId;
        this.message = message;
        this.chatId = chatId;
    }


    @Getter
    private long messageId;
    @Getter
    private long forwardTo;
    @Getter
    private String message;
    @Getter
    private long chatId;

    /**
     * @return
     */
    public TextMessage reply(String message){
        var msg = new TextMessage();
        msg.message = message;
        msg.chatId = chatId;
        msg.forwardTo = this.messageId;
        return msg;
    }

    /**
     * @param message
     * @return
     */
    public TextMessage answer(String message){
        var msg = new TextMessage();
        msg.message = message;
        msg.chatId = chatId;
        msg.messageId = this.messageId;
        return msg;
    }

}
