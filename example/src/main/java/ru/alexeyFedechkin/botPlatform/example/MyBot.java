package ru.alexeyFedechkin.botPlatform.example;

import ru.alexeyFedechkin.botPlatform.BotHandler;
import ru.alexeyFedechkin.botPlatform.Command.Command;
import ru.alexeyFedechkin.botPlatform.Message.*;

public class MyBot implements BotHandler {

    @Override
    public Message onText(TextMessage message) {
        return message;
    }

    @Override
    public Message onImage(ImageMessage message) {
        return message;
    }

    @Override
    public Message onAudio(AudioMessage message) {
        return message;
    }

    @Override
    public Message onVoice(VoiceMessage message) {
        return message;
    }

    @Override
    public Message onDocument(DocumentMessage message) {
        return message;
    }

    @Command(commandName = "/start")
    public static Message start(TextMessage message){
        return message.reply("this is work");
    }
}
