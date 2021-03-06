package me.nallaka.inixbot.commands.help;

import me.nallaka.inixbot.main.Command;
import me.nallaka.inixbot.maps.HelpCommandMap;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {
    HelpCommandMap helpCommandMap = new HelpCommandMap();

    @Override
    public boolean called(MessageReceivedEvent event, String[] args) {
        return true;
    }

    @Override
    public void runCommand(MessageReceivedEvent event, String[] args) {
        embeddedMessageBuilder.setTitle("Help")
                .setDescription("All the available commands")
                .addField("Empty", "I'm pretty empty. Come back later when I can do more stuff!", true);
        event.getTextChannel().sendMessage(embeddedMessageBuilder.build()).queue();
        messageHandler.clearEmbeddedBuilder(embeddedMessageBuilder);
    }

    @Override
    public void executed(MessageReceivedEvent event, String[] args) {
        commandLogger.logCommand(event, args);
    }
}
