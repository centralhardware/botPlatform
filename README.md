# bot platform

this is a library for writing chat bots, but unlike the classical libraries
for these purposes, where you write the bot only for one messenger in this
library, you can write the logic of the bot once and run it on all 
supported platforms
currently supported:
- telegram
- VK (in work)

### usage
To use the definition of bot behavior, 
you must redefine the interface methods BotHandler. 
Create class instance ?? and transfer there BotConfig

### feature

##### @Command

for handle command
 (it's string that start with '/' symbol, for example '/start')
 you can user @Command annotation. for example:
 
```java
@Command(commandName = "/start")
public static Message helloworld(TextMessage message){
    return message.reply("hello world");
}
```
When the bot receives a message that starts with a slash, 
if the code contains an annotation with this command, 
the message will be processed by the method annotated with this annotation,
 ps the text without the command will come to the method

#### echo bot example

you can find an example of echo bot in modules Example in the source code 
of the library

### supported type of message:
- text
- photo
- audio
- voice  

### tests 

since the platform uses its own types of messages that are independent of
specific implementations, 
you can test handlers deterministically in any way, without the need to
create an environment

### used library:
- [TelegramBots](https://github.com/rubenlagus/TelegramBots)
- [vk-bot-java-sdk](https://github.com/petersamokhin/vk-bot-java-sdk)
