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
                    Optional.of(new VKConfig(189752993,"62331e6545c9f1b5634baf2d0ec27c42a95cdc8de8cb22dc0eef335d769ab932f988b42db7921b748a4bc")),
                    true);
        } catch (ConfigException e) {
            e.printStackTrace();
        }
        Platform platform = new Platform(botConfig);
    }

}