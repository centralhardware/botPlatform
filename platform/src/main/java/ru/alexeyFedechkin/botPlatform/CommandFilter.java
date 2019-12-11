package ru.alexeyFedechkin.botPlatform;

import lombok.extern.log4j.Log4j;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import ru.alexeyFedechkin.botPlatform.Message.Message;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 *
 */
@Log4j
public class CommandFilter {

    private Map<String, Method> commands = new HashMap<>();

    public CommandFilter(Message message){

    }

    public Message doFilter(Message message) throws CommandFilteredException{
        return null;
    }

}
