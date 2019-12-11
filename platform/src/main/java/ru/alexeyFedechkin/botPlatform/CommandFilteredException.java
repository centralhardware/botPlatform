package ru.alexeyFedechkin.botPlatform;

import lombok.Getter;
import ru.alexeyFedechkin.botPlatform.Message.Message;

public class CommandFilteredException extends Exception {
    @Getter
    private Message message;

    public CommandFilteredException(Message message) {
        this.message = message;
    }
}
