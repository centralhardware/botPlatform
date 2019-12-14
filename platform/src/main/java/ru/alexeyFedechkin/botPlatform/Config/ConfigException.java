package ru.alexeyFedechkin.botPlatform.Config;

/**
 * Thrown if config is wrong
 * @author fedechkin_alexey
 */
public class ConfigException  extends Exception{

    public ConfigException(String message) {
        super(message);
    }
}
