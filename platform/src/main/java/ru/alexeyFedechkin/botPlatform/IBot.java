package ru.alexeyFedechkin.botPlatform;

import ru.alexeyFedechkin.botPlatform.Message.AudioMessage;
import ru.alexeyFedechkin.botPlatform.Message.ImageMessage;
import ru.alexeyFedechkin.botPlatform.Message.TextMessage;
import ru.alexeyFedechkin.botPlatform.Message.VoiceMessage;

/**
 * @author fedechkin_alexey
 */
public interface IBot {

   void sendText(TextMessage message);

   void onTextReceive(TextMessage message);

   void sendImage(ImageMessage message);

   void onImageReceive(ImageMessage message);

   void sendAudio(AudioMessage message);

   void onAudioReceive(AudioMessage message);

   void sendVoice(VoiceMessage message);

   void onVoiceReceive(VoiceMessage message);

}
