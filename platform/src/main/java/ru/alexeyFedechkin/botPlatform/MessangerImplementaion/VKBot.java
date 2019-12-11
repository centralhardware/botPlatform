package ru.alexeyFedechkin.botPlatform.MessangerImplementaion;

import ru.alexeyFedechkin.botPlatform.AbstractBot;
import ru.alexeyFedechkin.botPlatform.BotHandler;
import ru.alexeyFedechkin.botPlatform.Config.VKConfig;
import ru.alexeyFedechkin.botPlatform.Message.TextMessage;

/**
 * implementation of Abstract bot for VK
 * @author fedechkin_alexey
 */
public class VKBot extends AbstractBot {

    public VKBot(BotHandler handler, VKConfig config) {
        super(handler);
    }

    public void init() {

    }

    public void sendText(TextMessage message) {

    }

    public void onUpdate() {

    }
}
