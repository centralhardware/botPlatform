package ru.alexeyFedechkin.botPlatform;

import ru.alexeyFedechkin.botPlatform.Message.TextMessage;

/**
 * @author fedechkin_alexey
 */
public interface IBot {

   void sendText(TextMessage message);

   void onTextReceive(TextMessage message);

}
