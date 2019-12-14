package ru.alexeyFedechkin.botPlatform.Config;

import lombok.Getter;
import lombok.NonNull;
import ru.alexeyFedechkin.botPlatform.Telegram.TelegramConnectionType;

import java.util.Optional;

/**
 *  telegram bot configuration
 * @author fedechkin_alexey
 */
public class TelegramConfig {

    public TelegramConfig(@NonNull String username, @NonNull String token, @NonNull TelegramConnectionType type) throws ConfigException {
        if (username.isEmpty() || token.isEmpty()){
            throw new ConfigException("token or username are empty");
        }
        this.username = username;
        this.token = token;
        this.type = type;
        this.proxyConfig = Optional.empty();
    }

    public TelegramConfig(@NonNull String username, @NonNull String token, @NonNull TelegramConnectionType type, @NonNull ProxyConfig proxyConfig) throws ConfigException {
        this(username, token, type);
        this.proxyConfig = Optional.of(proxyConfig);
    }

    @Getter
    private String username;
    @Getter
    private String token;
    @Getter
    private TelegramConnectionType type;
    @Getter
    private Optional<ProxyConfig> proxyConfig;
}
