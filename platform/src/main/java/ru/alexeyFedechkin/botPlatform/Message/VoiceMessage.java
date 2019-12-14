package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Objects;

/**
 * 
 */
public class VoiceMessage implements Message {

    private VoiceMessage(Integer messageId,long chatId, String caption){
        this.chatId = chatId;
        this.caption = Objects.requireNonNullElse(caption, "");
        this.messageId = messageId;
    }

    public VoiceMessage(Integer messageId,long chatId, String caption, JSONObject voice) {
        this(messageId,chatId,caption);
        System.out.println(voice);
        this.voice = voice.getString("url");
    }

    public VoiceMessage(Integer messageId,long chatId, String caption, String voice) {
        this(messageId,chatId,caption);
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
}
