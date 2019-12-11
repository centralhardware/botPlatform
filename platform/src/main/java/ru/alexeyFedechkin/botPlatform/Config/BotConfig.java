package ru.alexeyFedechkin.botPlatform.Config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.alexeyFedechkin.botPlatform.BotHandler;

import java.util.Optional;

/**
 * configuration for bots
 * bot will be start if Optional is have object
 * @author fedechkin_alexey
 */
@AllArgsConstructor
@Builder
public class BotConfig {
    @Getter
    private BotHandler botHandler;
    @Getter
    private Optional<TelegramConfig> telegramConfig;
    @Getter
    private Optional<VKConfig> vkConfig;
    @Getter
    private boolean isCommandAnnotationSupport;

}
