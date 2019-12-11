package ru.alexeyFedechkin.botPlatform.MessangerImplementaion;

import lombok.extern.log4j.Log4j;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ru.alexeyFedechkin.botPlatform.AbstractBot;
import ru.alexeyFedechkin.botPlatform.BotHandler;
import ru.alexeyFedechkin.botPlatform.Config.TelegramConfig;
import ru.alexeyFedechkin.botPlatform.Telegram.TelegramLongPolingBot;
import ru.alexeyFedechkin.botPlatform.Message.TextMessage;

/**
 * implementation of Abstract bot for telegram
 * @author fedechkin_alexey
 */
@Log4j
public class TelegramBot extends AbstractBot {

    private TelegramLongPollingBot bot;

    static {
        ApiContextInitializer.init();
    }

    public TelegramBot(BotHandler handler, TelegramConfig config) {
        super(handler);
        bot = new TelegramLongPolingBot(config, update -> onUpdate(update));
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        log.info("telegram bot start");
    }

    public void sendText(TextMessage message) {
        log.info("sent text message: " + message.getMessage());
        sendText(message.getMessage(), message.getChatId());
    }

    public void onUpdate(Update update) {
        if (update.hasMessage()){
            log.info("receive text message: " + update.getMessage().getText());
            onTextReceive(new TextMessage(update.getMessage().getText(), update.getMessage().getChatId()));
        }
    }

    private void sendText(String text, long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try{
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
