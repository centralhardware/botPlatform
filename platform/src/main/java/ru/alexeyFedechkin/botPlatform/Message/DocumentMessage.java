package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.Document;

import java.util.Objects;

/**
 *
 */
public class DocumentMessage implements Message {

    private DocumentMessage(Integer messageId,long chatId, String caption){
        this.chatId = chatId;
        this.caption = Objects.requireNonNullElse(caption, "");
        this.messageId = messageId;
    }

    public DocumentMessage(Integer messageId,Integer chatId, String caption, @NonNull JSONArray document) {
        this(messageId,chatId, caption);
//        this.document = document.getJSONObject("doc").getString("url");
    }

    public DocumentMessage(Integer messageId,long chatId, String caption, @NonNull Document document) {
        this(messageId,chatId, caption);
        this.document = document.getFileId();
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
    private String document;
}
