# bot platform

this is a library for writing chat bots, but unlike the classical libraries
for these purposes, where you write the bot only for one messenger in this
library, you can write the logic of the bot once and run it on all 
supported platforms
currently supported:
- telegram
- VK (in work)

###usage
To use the definition of bot behavior, 
you must redefine the interface methods BotHandler. 
Create class instance ?? and transfer there BotConfig

####echo bot example

you can find an example of echo bot in modules Example in the source code 
of the library

###supported type of message:
- text
- photo
- audio
- voice  

###used library:
- [TelegramBots](https://github.com/rubenlagus/TelegramBots)
- [vk-bot-java-sdk](https://github.com/petersamokhin/vk-bot-java-sdk)