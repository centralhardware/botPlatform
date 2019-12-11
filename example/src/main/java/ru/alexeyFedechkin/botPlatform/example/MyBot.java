package ru.alexeyFedechkin.botPlatform.example;

import ru.alexeyFedechkin.botPlatform.BotHandler;
import ru.alexeyFedechkin.botPlatform.Message.Message;
import ru.alexeyFedechkin.botPlatform.Message.TextMessage;

public class MyBot implements BotHandler {

    public Message onText(TextMessage message) {
        return message;
    }
}
