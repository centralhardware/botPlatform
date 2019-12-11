package ru.alexeyFedechkin.botPlatform.Telegram;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author fedechkin_alexey
 */
public interface TelegramUpdateListener {

    void update(Update update);

}
