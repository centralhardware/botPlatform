package ru.alexeyFedechkin.botPlatform.Config;

import lombok.Getter;
import org.telegram.telegrambots.bots.DefaultBotOptions;

/**
 *
 */
public class ProxyConfig {

    public ProxyConfig(String host, int port, DefaultBotOptions.ProxyType proxyType) throws ConfigException {
        if (!validatePort(port)){
            throw new ConfigException("port number is out of range");
        }
        this.host = host;
        this.port = port;
        this.proxyType = proxyType;
    }

    @Getter
    private String host;
    @Getter
    private int port;
    @Getter
    private DefaultBotOptions.ProxyType proxyType;

    private static final int MAX_PORT_NUMBER = 65535;
    private static final int MIN_PORT_NUMBER = 0;
    /**
     * @param port
     * @return
     */
    private static boolean validatePort(int port){
        return port >= MIN_PORT_NUMBER && port <= MAX_PORT_NUMBER;
    }
}
