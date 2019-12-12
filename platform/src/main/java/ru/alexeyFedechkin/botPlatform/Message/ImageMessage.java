package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import lombok.NonNull;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

import java.util.List;

/**
 * presentation of a message with an image
 * @author fedechkin_alexey
 */
public class ImageMessage implements Message {

    public ImageMessage(long chatId, String caption){
        this.chatId = chatId;
        if (caption == null){
            this.caption = "";
        } else {
            this.caption = caption;
        }
    }

    public ImageMessage(@NonNull long chatId,String caption, @NonNull List<PhotoSize> images) {
        this(chatId, caption);
        this.image = images.get(0).getFileId();
    }

    public ImageMessage(long chatId, String caption, String image) {
        this(chatId, caption);
        this.image = image;
    }

    @Getter
    private long chatId;
    @Getter
    private String caption;
    @Getter
    private String image;
}