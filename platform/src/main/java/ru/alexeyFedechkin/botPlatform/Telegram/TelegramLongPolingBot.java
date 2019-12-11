package ru.alexeyFedechkin.botPlatform.Telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.alexeyFedechkin.botPlatform.Config.TelegramConfig;

/**
 * implement of telegram bot with long poling connection type
 * @author fedechkin_alexey
 */
public class TelegramLongPolingBot extends TelegramLongPollingBot {

    private TelegramConfig config;
    private TelegramUpdateListener listener;

    public TelegramLongPolingBot(TelegramConfig config, TelegramUpdateListener listener){
        this.config = config;
        this.listener = listener;
    }

    public void onUpdateReceived(Update update) {
        listener.update(update);
    }

    public String getBotUsername() {
        return config.getUsername();
    }

    public String getBotToken() {
        return config.getToken();
    }

}
