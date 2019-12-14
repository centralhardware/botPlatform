package ru.alexeyFedechkin.botPlatform.Config;

import lombok.Getter;
import lombok.NonNull;

/**
 * vk bot configuration
 * @author fedechkin_alexey
 */
public class VKConfig {

    public VKConfig(@NonNull Integer id, @NonNull String accessToken) throws ConfigException {
        if (accessToken.isEmpty()){
            throw new ConfigException("access token is empty");
        }
        this.id = id;
        this.accessToken = accessToken;
    }

    @Getter
    private Integer id;
    @Getter
    private String accessToken;
}
