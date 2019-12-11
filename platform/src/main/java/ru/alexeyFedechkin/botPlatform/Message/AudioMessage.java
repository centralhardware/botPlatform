package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import lombok.NonNull;
import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.objects.Audio;

import java.io.File;

/**
 * audio message submission
 * @author fedechkin_alexey
 */
public class AudioMessage implements Message {

    public AudioMessage(long chatId, String caption){
        this.chatId = chatId;
        if (caption == null){
            this.caption = "";
        } else {
            this.caption = caption;
        }
    }

    public AudioMessage(long chatId, String caption, @NonNull JSONObject audio) {
        this(chatId, caption);
    }

    public AudioMessage(long chatId, String caption, @NonNull Audio audio) {
        this(chatId, caption);
        this.audio = audio.getFileId();
    }

    public AudioMessage(long chatId, String caption, @NonNull String audio) {
        this(chatId, caption);
        this.audio = audio;
    }

    @Getter
    private long chatId;
    @Getter
    private String caption;
    @Getter
    private String audio;
}
