package ru.alexeyFedechkin.botPlatform.MessangerImplementaion;

import com.petersamokhin.bots.sdk.clients.Group;
import com.petersamokhin.bots.sdk.objects.Message;
import com.petersamokhin.bots.sdk.utils.vkapi.docs.DocTypes;
import lombok.extern.log4j.Log4j;
import ru.alexeyFedechkin.botPlatform.AbstractBot;
import ru.alexeyFedechkin.botPlatform.BotHandler;
import ru.alexeyFedechkin.botPlatform.Config.VKConfig;
import ru.alexeyFedechkin.botPlatform.Message.AudioMessage;
import ru.alexeyFedechkin.botPlatform.Message.ImageMessage;
import ru.alexeyFedechkin.botPlatform.Message.TextMessage;
import ru.alexeyFedechkin.botPlatform.Message.VoiceMessage;

/**
 * implementation of Abstract bot for VK
 * @author fedechkin_alexey
 */
@Log4j
public class VKBot extends AbstractBot {

    private Group group;

    public VKBot(BotHandler handler, VKConfig config, boolean isCommandSupport) {
        super(handler, isCommandSupport);
        group = new Group(config.getId(), config.getAccessToken());
        group.onSimpleTextMessage(message -> {
            log.info("receive text message " + message.getText());
            onTextReceive(new TextMessage(message.getMessageId() ,message.getText(), message.authorId()));
        });
        group.onPhotoMessage(message -> {
            log.info("receive photo message " + message.getBiggestPhotoUrl(message.getPhotos()));
            onImageReceive(new ImageMessage(message.authorId(), message.getText(), message.getBiggestPhotoUrl(message.getPhotos())));
        });
        group.onAudioMessage(message -> {
            log.info("receive audio message ");
            onAudioReceive(new AudioMessage(message.authorId(), message.getText(), message.getVoiceMessage()));
        });
        group.onVoiceMessage(message -> {
            log.info("receive voice message " );
            onVoiceReceive(new VoiceMessage(message.authorId(), message.getText(), message.getVoiceMessage()));
        });
        log.info("vk bot start");
    }

    @Override
    public void sendText(TextMessage message) {
        log.info("send message: " + message.getMessage());
        new Message().
                from(group).
                to((int) message.getChatId()).
                text(message.getMessage()).
                send();
    }

    @Override
    public void sendImage(ImageMessage message) {
        log.info("send photo message: " + message.getCaption());
        new Message().
                from(group).
                to((int) message.getChatId()).
                photo(message.getImage()).
                send();
    }

    @Override
    public void sendAudio(AudioMessage message) {
        log.info("send audio message: " + message.getCaption());
        new Message().
                from(group).
                to((int) message.getChatId()).
                doc(message.getAudio(), DocTypes.AUDIO_MESSAGE).
                send();
    }

    @Override
    public void sendVoice(VoiceMessage message) {

    }


}
