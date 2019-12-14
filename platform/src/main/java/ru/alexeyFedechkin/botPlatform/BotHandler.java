package ru.alexeyFedechkin.botPlatform;

import ru.alexeyFedechkin.botPlatform.Message.*;

/**
 * interface of methods that determine the behavior of the bot
 * @author fedechkin_alexey
 */
public interface BotHandler {

    Message onText(TextMessage message);

    Message onImage(ImageMessage message);

    Message onAudio(AudioMessage message);

    Message onVoice(VoiceMessage message);

    Message onDocument(DocumentMessage message);

}
