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

    /**
     * redirecting incoming updates to the implementation of AbstractBot through the listener
     * @param update incoming update
     */
    @Override
    public void onUpdateReceived(Update update) {
        listener.update(update);
    }

    @Override
    public String getBotUsername() {
        return config.getUsername();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

}
