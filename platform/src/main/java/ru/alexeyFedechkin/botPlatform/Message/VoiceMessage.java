package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Objects;

/**
 * 
 */
public class VoiceMessage implements Message {

    public VoiceMessage(long chatId, String caption){
        this.chatId = chatId;
        this.caption = Objects.requireNonNullElse(caption, "");
    }

    public VoiceMessage(long chatId, String caption, JSONObject voice) {

    }

    public VoiceMessage(long chatId, String caption, String voice) {
        this(chatId,caption);
        this.voice = voice;

    }

    @Getter
    private long chatId;
    @Getter
    private String caption;
    @Getter
    private String voice;
}
