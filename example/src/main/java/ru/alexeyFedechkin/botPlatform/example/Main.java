package ru.alexeyFedechkin.botPlatform.example;


import ru.alexeyFedechkin.botPlatform.Platform;
import ru.alexeyFedechkin.botPlatform.Config.BotConfig;
import ru.alexeyFedechkin.botPlatform.Config.TelegramConfig;
import ru.alexeyFedechkin.botPlatform.Telegram.TelegramConnectionType;

import java.util.Optional;


public class Main {

    public  static void main(String[] args){
        BotConfig botConfig = new BotConfig(new MyBot(),Optional.of(new TelegramConfig("edddfsbot", "1063012284:AAEgtL7vGmmAbQc3nauVFfYwZip7kiEiY9I", TelegramConnectionType.LONG_POOLING)), Optional.empty());
        Platform platform = new Platform(botConfig);
    }

}