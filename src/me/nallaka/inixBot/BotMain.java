package me.nallaka.inixBot;

import me.nallaka.inixBot.commands.HelpCommand;
import me.nallaka.inixBot.commands.JoinClassCommand;
import me.nallaka.inixBot.commands.PingCommand;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

public class BotMain extends ListenerAdapter implements EventListener {

    public static Map<String, Command> commands = new HashMap<>();

    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException {
        //Bot Setup
        String botToken = "MzU2MjY5MTQ5NjAyOTcxNjQ5.DJY5Cg.OQONQOwYNjvVaQdjBsGXLf5JMmk";
        JDA jda = new JDABuilder(AccountType.BOT).setToken(botToken).buildBlocking();
        jda.addEventListener(new MessageListener());

        //Commands HashMap Setup
        commands.put("help", new HelpCommand());
        commands.put("ping", new PingCommand());
        commands.put("joinclass", new JoinClassCommand());
    }
}