package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.objects.Audio;

import java.util.Objects;

/**
 * audio message submission
 * @author fedechkin_alexey
 */
public class AudioMessage implements Message {

    public AudioMessage(long chatId, String caption){
        this.chatId = chatId;
        this.caption = Objects.requireNonNullElse(caption, "");
    }

    public AudioMessage(long chatId, String caption, @NonNull JSONObject audio) {
        this(chatId, caption);
        this.audio = audio.getString("attach1");
        System.out.println(audio);
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
    private long messageId;
    @Getter
    @Setter
    private long replayTo;
    @Getter
    private long chatId;
    @Getter
    private String caption;
    @Getter
    private String audio;


}
