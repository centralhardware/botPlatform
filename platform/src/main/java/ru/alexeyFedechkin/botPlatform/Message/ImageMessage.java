package ru.alexeyFedechkin.botPlatform.Message;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Objects;

/**
 * presentation of a message with an image
 * @author fedechkin_alexey
 */
public class ImageMessage implements Message {

    private ImageMessage(Integer messageId,long chatId, String caption){
        this.chatId = chatId;
        this.caption = Objects.requireNonNullElse(caption, "");
        this.messageId = messageId;
    }


    public ImageMessage(Integer messageId,long chatId, String caption, String image, File imageFile) {
        this(messageId,chatId, caption);
        this.image = image;
        this.imageFile = imageFile;
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
    private String image;
    @Getter
    private File imageFile;
}
