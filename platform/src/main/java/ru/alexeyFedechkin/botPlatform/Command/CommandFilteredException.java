package ru.alexeyFedechkin.botPlatform.Command;

import lombok.Getter;
import ru.alexeyFedechkin.botPlatform.Message.Message;

/**
 * Thrown if in TextMessage found command then will be handle by the annotated method
 * @author fedechkin_alexey
 */
public class CommandFilteredException extends Exception {

    /**
     * answer of annotated method that handle incoming TextMessage
     */
    @Getter
    private Message msg;

    public CommandFilteredException(Message message) {
        this.msg = message;
    }
}
