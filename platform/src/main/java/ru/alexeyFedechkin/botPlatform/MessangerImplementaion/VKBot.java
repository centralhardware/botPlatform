package ru.alexeyFedechkin.botPlatform.MessangerImplementaion;

import com.petersamokhin.bots.sdk.clients.Group;
import com.petersamokhin.bots.sdk.objects.Message;
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

    public VKBot(BotHandler handler, VKConfig config) {
        super(handler);
        group = new Group(config.getId(), config.getAccessToken());
        group.onSimpleTextMessage(message -> onTextReceive(new TextMessage(message.getText(), message.authorId())));
        group.onPhotoMessage(message -> onImageReceive(new ImageMessage(message.authorId(), message.getText(), message.getBiggestPhotoUrl(message.getPhotos()))));
        group.onAudioMessage(message -> onAudioReceive(new AudioMessage(message.authorId(), message.getText(), message.getVoiceMessage())));
        group.onVoiceMessage(message -> onVoiceReceive(new VoiceMessage(message.authorId(), message.getText(), message.getVoiceMessage())));
        log.info("vk bot start");
    }

    @Override
    public void sendText(TextMessage message) {
        new Message().
                from(group).
                to((int) message.getChatId()).
                text(message.getMessage()).
                send();
    }

    @Override
    public void sendImage(ImageMessage message) {
        System.out.println(message.getImage());
        new Message().
                from(group).
                to((int) message.getChatId()).
                photo(message.getImage()).
                send();
    }

    @Override
    public void sendAudio(AudioMessage message) {

    }

    @Override
    public void sendVoice(VoiceMessage message) {

    }


}
