package ru.alexeyFedechkin.botPlatform.MessangerImplementaion;

import lombok.extern.log4j.Log4j;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import ru.alexeyFedechkin.botPlatform.AbstractBot;
import ru.alexeyFedechkin.botPlatform.BotHandler;
import ru.alexeyFedechkin.botPlatform.Config.TelegramConfig;
import ru.alexeyFedechkin.botPlatform.Message.*;
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
                    if (config.getProxyConfig().isPresent()){
                        var proxyConfig = config.getProxyConfig().get();
                        var botOption = ApiContext.getInstance(DefaultBotOptions.class);
                        botOption.setProxyHost(proxyConfig.getHost());
                        botOption.setProxyPort(proxyConfig.getPort());
                        botOption.setProxyType(proxyConfig.getProxyType());
                        bot = new TelegramLongPolingBot(config, this::onUpdate, botOption);
                        botsApi.registerBot((LongPollingBot) bot);
                    } else {
                        bot = new TelegramLongPolingBot(config, this::onUpdate);
                        botsApi.registerBot((LongPollingBot) bot);
                    }

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
            var message = update.getMessage();
            var messageId = message.getMessageId();
            if (update.getMessage().hasAudio()){
                log.info("receive audio message: " + message.getAudio().getTitle());
                onAudioReceive(new AudioMessage(messageId,message.getChatId(),message.getCaption(),message.getAudio()));
            }
            if (update.getMessage().hasVoice()){
                log.info("receive voice message: " + message.getVoice().getFileId());
                onVoiceReceive(new VoiceMessage(messageId,message.getChatId(),message.getCaption(),message.getVoice().getFileId()));
            }
            if (update.getMessage().hasPhoto()){
                log.info("receive photo message: " + message.getPhoto().get(0).getFileId());
                onImageReceive(new ImageMessage(messageId,message.getChatId(), message.getCaption(), message.getPhoto()));
            }
            if (update.getMessage().hasText()){
                log.info("receive text message: " + message.getText());
                onTextReceive(new TextMessage(messageId ,message.getText(),message.getChatId()));
            }
            if (update.getMessage().hasDocument()){
                log.info("receive document message " + message.getDocument().getFileName());
                onDocumentReceive(new DocumentMessage(messageId,message.getChatId(), message.getCaption(),message.getDocument()));
            }
        }
    }

    @Override
    public void sendText(TextMessage message) {
        SendMessage sendMessage = new SendMessage().
                setChatId(message.getChatId()).
                setText(message.getMessage()).
                setReplyToMessageId((int) message.getReplyTo());
        try{
            bot.execute(sendMessage);
            log.info("sent text message: " + message.getMessage());
        } catch (TelegramApiException e) {
            log.info("", e);
        }
    }

    @Override
    public void sendImage(ImageMessage message) {
        SendPhoto sendPhoto = new SendPhoto().
                setChatId(message.getChatId()).
                setPhoto(message.getImage()).
                setCaption(message.getCaption());
        if (message.getReplyTo() != 0){
            sendPhoto.setReplyToMessageId((int) message.getReplyTo());
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
        SendAudio sendAudio = new SendAudio().
                setChatId(message.getChatId()).
                setCaption(message.getCaption()).
                setAudio(message.getAudio()).
                setReplyToMessageId((int) message.getReplayTo());
        try {
            bot.execute(sendAudio);
            log.info("sent audio message");
        } catch (TelegramApiException e) {
            log.info("", e);
        }
    }

    @Override
    public void sendVoice(VoiceMessage message) {
        SendVoice sendVoice = new SendVoice().
                setChatId(message.getChatId()).
                setCaption(message.getCaption()).
                setVoice(message.getVoice()).
                setReplyToMessageId((int) message.getReplyTo());
        try {
            bot.execute(sendVoice);
            log.info("sent voice message");
        } catch (TelegramApiException e) {
            log.info("", e);
        }
    }

    @Override
    public void sendDocument(DocumentMessage message) {
        SendDocument sendDocument = new SendDocument().
                setChatId(message.getChatId()).
                setCaption(message.getCaption()).
                setDocument(message.getDocument()).
                setReplyToMessageId((int) message.getReplayTo());
        try {
            bot.execute(sendDocument);
            log.info("sent document message ");
        } catch (TelegramApiException e) {
            log.info("", e);
        }
    }
}
