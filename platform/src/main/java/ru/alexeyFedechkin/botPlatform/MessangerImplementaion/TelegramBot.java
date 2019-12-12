package ru.alexeyFedechkin.botPlatform.MessangerImplementaion;

import lombok.extern.log4j.Log4j;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import ru.alexeyFedechkin.botPlatform.AbstractBot;
import ru.alexeyFedechkin.botPlatform.BotHandler;
import ru.alexeyFedechkin.botPlatform.Config.TelegramConfig;
import ru.alexeyFedechkin.botPlatform.Message.AudioMessage;
import ru.alexeyFedechkin.botPlatform.Message.ImageMessage;
import ru.alexeyFedechkin.botPlatform.Message.TextMessage;
import ru.alexeyFedechkin.botPlatform.Message.VoiceMessage;
import ru.alexeyFedechkin.botPlatform.Telegram.TelegramLongPolingBot;

/**
 * implementation of Abstract bot for telegram
 * @author fedechkin_alexey
 */
@Log4j
public class TelegramBot extends AbstractBot {

    private DefaultAbsSender bot;

    static {
        ApiContextInitializer.init();
    }

    public TelegramBot(BotHandler handler, TelegramConfig config, boolean isCommandSupport) {
        super(handler, isCommandSupport);
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try{
            switch (config.getType()){
                case LONG_POOLING:{
                    bot = new TelegramLongPolingBot(config, this::onUpdate);
                    botsApi.registerBot((LongPollingBot) bot);
                }
                case WEB_HOOK:break;
            }
        } catch (TelegramApiRequestException e) {
            log.info("", e);
        }
        log.info("telegram bot start");
    }

    /**
     * redirecting incoming message to handlers
     * @param update incoming update
     */
    public void onUpdate(Update update) {
        if (update.hasMessage()){
            if (update.getMessage().hasAudio()){
                log.info("receive audio message: " + update.getMessage().getAudio().getTitle());
                onAudioReceive(new AudioMessage(update.getMessage().getChatId(), update.getMessage().getCaption(), update.getMessage().getAudio()));
            }
            if (update.getMessage().hasVoice()){
                log.info("receive voice message: " + update.getMessage().getVoice().getFileId());
                onVoiceReceive(new VoiceMessage(update.getMessage().getChatId(), update.getMessage().getCaption(), update.getMessage().getVoice().getFileId()));
            }
            if (update.getMessage().hasPhoto()){
                log.info("receive photo message: " + update.getMessage().getPhoto().get(0).getFileId());
                onImageReceive(new ImageMessage(update.getMessage().getChatId(), update.getMessage().getCaption(), update.getMessage().getPhoto()));
            }
            if (update.getMessage().hasText()){
                log.info("receive text message: " + update.getMessage().getText());
                onTextReceive(new TextMessage(update.getMessage().getText(), update.getMessage().getChatId()));
            }
        }
    }

    @Override
    public void sendText(TextMessage message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(message.getMessage());
        try{
            bot.execute(sendMessage);
            log.info("sent text message: " + message.getMessage());
        } catch (TelegramApiException e) {
            log.info("", e);
        }
    }

    @Override
    public void sendImage(ImageMessage message) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(message.getImage());
        if (!message.getCaption().isEmpty()){
            sendPhoto.setCaption(message.getCaption());
        }
        try {
            bot.execute(sendPhoto);
            log.info("sent photo message");
        } catch (TelegramApiException e) {
            log.info("", e);
        }
    }

    @Override
    public void sendAudio(AudioMessage message) {
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(message.getChatId());
        sendAudio.setCaption(message.getCaption());
        sendAudio.setAudio(message.getAudio());
        try {
            bot.execute(sendAudio);
            log.info("sent audio message");
        } catch (TelegramApiException e) {
            log.info("", e);
        }
    }

    @Override
    public void sendVoice(VoiceMessage message) {
        SendVoice sendVoice = new SendVoice();
        sendVoice.setChatId(message.getChatId());
        sendVoice.setCaption(message.getCaption());
        sendVoice.setVoice(message.getVoice());
        try {
            bot.execute(sendVoice);
            log.info("sent voice message");
        } catch (TelegramApiException e) {
            log.info("", e);
        }
    }
}
