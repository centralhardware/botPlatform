package ru.alexeyFedechkin.botPlatform;

import ru.alexeyFedechkin.botPlatform.Message.*;

/**
 * @author fedechkin_alexey
 */
public interface IBot {
   //********************************************************
   // must be implemented for each MessengerImplementation
   //********************************************************
   void sendText(TextMessage message);

   void sendImage(ImageMessage message);

   void sendAudio(AudioMessage message);

   void sendVoice(VoiceMessage message);

   void sendDocument(DocumentMessage message);
   //********************************************************
   // implemented in AbstractBot
   //********************************************************
   void onTextReceive(TextMessage message);

   void onImageReceive(ImageMessage message);

   void onAudioReceive(AudioMessage message);

   void onVoiceReceive(VoiceMessage message);

   void onDocumentReceive(DocumentMessage message);
}
