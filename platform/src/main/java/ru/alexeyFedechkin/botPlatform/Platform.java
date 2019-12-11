package ru.alexeyFedechkin.botPlatform;

import lombok.extern.log4j.Log4j;
import ru.alexeyFedechkin.botPlatform.Config.BotConfig;
import ru.alexeyFedechkin.botPlatform.MessangerImplementaion.TelegramBot;

import java.util.ArrayList;
import java.util.List;

/**
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
            botList.add(new TelegramBot(config.getBotHandler(), config.getTelegramConfig().get()));
        }
        log.info("bot platform start");
    }
}
