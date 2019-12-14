package ru.alexeyFedechkin.botPlatform.Command;

import lombok.extern.log4j.Log4j;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import ru.alexeyFedechkin.botPlatform.Message.Message;
import ru.alexeyFedechkin.botPlatform.Message.TextMessage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author fedechkin_alexey
 */
@Log4j
public class CommandFilter {

    private Map<String, Method> commands = new HashMap<>();

    /**
     * validate  methods annotated @Command and put valid method to HashMap
     */
    public CommandFilter(){
        var methods = getCommandMethods();
        for (Method method : methods){
            if (method.getAnnotation(Command.class).commandName().contains(" ")){
                throw new RuntimeException("commandName contain space for method " + method.getName());
            }
            if (method.getParameterCount() != 1){
                throw new RuntimeException("methods " + method.getName() + " annotated @Command have " +
                        method.getParameterCount() + " but expected 1");
            }
            if (!method.getReturnType().equals(Message.class)){
                throw new RuntimeException("methods " + method.getName() + " annotated @Command have return type" +
                        method.getReturnType() + " but expected Message");
            }
            if (!method.getParameterTypes()[0].equals(TextMessage.class)){
                throw new RuntimeException("methods " + method.getName() + " annotated @Command have parameter " +
                        method.getParameterTypes()[0].getName() + " but expected TextMessage");
            }
            if (!Modifier.isStatic(method.getModifiers())){
                throw new RuntimeException("methods " + method.getName() + " annotated @Command is none static");
            }
            if (!method.getAnnotation(Command.class).commandName().startsWith("/")){
                throw new RuntimeException("field commandName in @Command must start with / for method " + method.getName());
            }
            commands.put(method.getAnnotation(Command.class).commandName(), method);
        }
    }

    /**
     * check TextMessage on command
     * @param message incoming message
     * @throws CommandFilteredException thrown if message handled
     */
    public void doFilter(TextMessage message) throws CommandFilteredException{
        if (message.getMessage().startsWith("/")){
            for (String commandName : commands.keySet()){
                if (message.getMessage().startsWith(commandName)){
                    try {
                        Message answer = (Message) commands.get(commandName).invoke(
                                null,message.answer(message.getMessage().replace(commandName,"")));
                        throw new CommandFilteredException(answer);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        log.info("", e);
                    }
                }
            }
        }
    }

    /**
     * count of method annotated with @Command
     * @return count of method
     */
    public static int getCountOfAnnotatedMethod(){
        return getCommandMethods().size();
    }

    /**
     *  get method that annotated with @Command
     * @return Set of method
     */
    private static Set<Method> getCommandMethods() {
        Reflections reflections = new Reflections("",new MethodAnnotationsScanner());
        return reflections.getMethodsAnnotatedWith(Command.class);
    }

}
