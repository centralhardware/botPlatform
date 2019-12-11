package ru.alexeyFedechkin.botPlatform.example;


import ru.alexeyFedechkin.botPlatform.Config.ConfigException;
import ru.alexeyFedechkin.botPlatform.Config.VKConfig;
import ru.alexeyFedechkin.botPlatform.Platform;
import ru.alexeyFedechkin.botPlatform.Config.BotConfig;
import ru.alexeyFedechkin.botPlatform.Config.TelegramConfig;
import ru.alexeyFedechkin.botPlatform.Telegram.TelegramConnectionType;

import java.util.Optional;


public class Main {

    public  static void main(String[] args){
        BotConfig botConfig = null;
        try {
            botConfig = new BotConfig(new MyBot(),
                    Optional.of(new TelegramConfig("edddfsbot", "1063012284:AAEgtL7vGmmAbQc3nauVFfYwZip7kiEiY9I", TelegramConnectionType.LONG_POOLING)),
                    Optional.of(new VKConfig(189752993,"203930e290b49b798a81eff3138d478e02620d542c72cf65c65d19ff5f157ca7d3bf1eb01dead0b4f93ac")), true);
        } catch (ConfigException e) {
            e.printStackTrace();
        }
        Platform platform = new Platform(botConfig);
    }

}