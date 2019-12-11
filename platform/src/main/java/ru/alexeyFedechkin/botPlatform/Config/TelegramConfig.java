package ru.alexeyFedechkin.botPlatform.Config;

import lombok.Getter;
import ru.alexeyFedechkin.botPlatform.Telegram.TelegramConnectionType;

/**
 *  telegram bot configuration
 * @author fedechkin_alexey
 */
public class TelegramConfig {
    public TelegramConfig(String username, String token, TelegramConnectionType type) {
        this.username = username;
        this.token = token;
        this.type = type;
    }

    @Getter
    private String username;
    @Getter
    private String token;
    @Getter
    private TelegramConnectionType type;
}
