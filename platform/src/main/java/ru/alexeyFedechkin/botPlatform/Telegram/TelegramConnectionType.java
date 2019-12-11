package ru.alexeyFedechkin.botPlatform.Telegram;

/**
 * type of connection to the telegram server
 * @author fedechkin_alexey
 */
public enum TelegramConnectionType {
    /**
     * requesting data from the server via https.
     * It can be applied with a proxy.
     * initiator of data transfer the client.
     */
    LONG_POOLING,
    /**
     * permanent connection to the server.
     * Cannot be applied with proxies.
     * Initiator of data transfer server.
     */
    WEB_HOOK
}
