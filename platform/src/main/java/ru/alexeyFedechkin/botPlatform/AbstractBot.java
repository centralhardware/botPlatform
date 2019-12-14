package ru.alexeyFedechkin.botPlatform;

import lombok.extern.log4j.Log4j;
import ru.alexeyFedechkin.botPlatform.Command.CommandFilter;
import ru.alexeyFedechkin.botPlatform.Command.CommandFilteredException;
import ru.alexeyFedechkin.botPlatform.Message.*;

/**
 * implementation of methods that work with BotHandler object
 * @see BotHandler
 * @author fedechkin_alexey
 */
@Log4j
public abstract class AbstractBot implements IBot {

    private final BotHandler handler;
    private final boolean isCommandAnnotationSupport;
    private CommandFilter filter;

    protected AbstractBot(BotHandler handler, boolean isCommandAnnotationSupport) {
        this.handler = handler;
        this.isCommandAnnotationSupport = isCommandAnnotationSupport;
        if (isCommandAnnotationSupport){
            filter = new CommandFilter();
        } else {
            if (CommandFilter.getCountOfAnnotatedMethod() > 0){
                log.info("isCommandAnnotationSupport = false but found " + CommandFilter.getCountOfAnnotatedMethod() + " @Command annotation");
            }
        }
    }

    /**
     * @implNote не нашел как сделать фильтрацию лучше
     * @param message incoming text message
     */
    @Override
    public void onTextReceive(TextMessage message) {
        if (isCommandAnnotationSupport){
            try {
                filter.doFilter(message);
            } catch (CommandFilteredException e) {
                sendMessage(e.getMsg());
                return;
            }
        }
        Message answer = handler.onText(message);
        sendMessage(answer);
    }

    @Override
    public void onImageReceive(ImageMessage message) {
        Message answer = handler.onImage(message);
        sendMessage(answer);

    }

    @Override
    public void onAudioReceive(AudioMessage message) {
        Message answer = handler.onAudio(message);
        sendMessage(answer);
    }

    @Override
    public void onVoiceReceive(VoiceMessage message) {
        Message answer =  handler.onVoice(message);
        sendMessage(answer);
    }

    @Override
    public void onDocumentReceive(DocumentMessage message) {
        Message answer = handler.onDocument(message);
        sendMessage(answer);
    }

    /**
     * sending a response according to type
     * @param answer message to sent
     */
    private void sendMessage(Message answer){
        if (answer instanceof TextMessage){
            sendText((TextMessage) answer);
        } else if (answer instanceof ImageMessage){
            sendImage((ImageMessage) answer);
        } else if (answer instanceof  AudioMessage){
            sendAudio((AudioMessage) answer);
        } else if (answer instanceof VoiceMessage){
            sendVoice((VoiceMessage) answer);
        } else if (answer instanceof DocumentMessage){
            sendDocument((DocumentMessage) answer);
        }
    }
}
