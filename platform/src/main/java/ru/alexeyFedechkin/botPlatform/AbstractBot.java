package ru.alexeyFedechkin.botPlatform;

import ru.alexeyFedechkin.botPlatform.Message.Message;
import ru.alexeyFedechkin.botPlatform.Message.TextMessage;

/**
 * @author fedechkin_alexey
 */
public abstract class AbstractBot implements IBot {

    private BotHandler handler;

    protected AbstractBot(BotHandler handler) {
        this.handler = handler;
    }

    public void onTextReceive(TextMessage message) {
        Message answer = handler.onText(message);
        if (answer instanceof TextMessage){
            sendText((TextMessage) answer);
        }
    }
}
