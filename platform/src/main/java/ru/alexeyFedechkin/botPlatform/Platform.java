package ru.alexeyFedechkin.botPlatform;

import lombok.extern.log4j.Log4j;
import ru.alexeyFedechkin.botPlatform.Config.BotConfig;
import ru.alexeyFedechkin.botPlatform.MessangerImplementaion.TelegramBot;
import ru.alexeyFedechkin.botPlatform.MessangerImplementaion.VKBot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedechkin_alexey
 */
@Log4j
public class Platform {

    private List<IBot> botList = new ArrayList<>();

    /**
     * @param config bots configuration
     */
    public Platform(BotConfig config){
        if (config.getTelegramConfig().isPresent()){
            botList.add(new TelegramBot(config.getBotHandler(), config.getTelegramConfig().get(), config.isCommandAnnotationSupport()));
        }
        if (config.getVkConfig().isPresent()){
            botList.add(new VKBot(config.getBotHandler(), config.getVkConfig().get(), config.isCommandAnnotationSupport()));
        }
        log.info("bot platform start");
    }
}
