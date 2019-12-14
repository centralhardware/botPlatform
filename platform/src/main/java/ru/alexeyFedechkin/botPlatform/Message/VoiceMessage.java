package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.io.File;
import java.util.Objects;

/**
 * 
 */
public class VoiceMessage implements Message {

    private VoiceMessage(Integer messageId,long chatId, String caption, File voiceFile){
        this.chatId = chatId;
        this.caption = Objects.requireNonNullElse(caption, "");
        this.messageId = messageId;
        this.voiceFile = voiceFile;
    }

    public VoiceMessage(Integer messageId,long chatId, String caption, String voice, File voiceFile) {
        this(messageId,chatId,caption, voiceFile);
        this.voice = voice;

    }

    @Getter
    private long messageId;
    @Getter
    @Setter
    private long replyTo;
    @Getter
    private long chatId;
    @Getter
    private String caption;
    @Getter
    private String voice;
    @Getter
    private File voiceFile;
}
