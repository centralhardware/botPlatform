package ru.alexeyFedechkin.botPlatform;

import ru.alexeyFedechkin.botPlatform.Message.Message;
import ru.alexeyFedechkin.botPlatform.Message.TextMessage;

/**
 * @author fedechkin_alexey
 */
public interface BotHandler {

    Message onText(TextMessage message);

}
