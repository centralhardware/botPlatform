package ru.alexeyFedechkin.botPlatform.Command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * annotated method must be static, have one parameter with type TextMessage, return type Message
 * @author fedechkin_alexey
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Command {
    /**
     * example: '/start'
     * must startWith '/' and don't contain spaces
     */
    String commandName();
}
