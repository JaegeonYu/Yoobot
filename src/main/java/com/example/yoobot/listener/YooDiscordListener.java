package com.example.yoobot.listener;

import com.example.yoobot.config.DiscordBotToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;
import java.util.StringTokenizer;

@Slf4j
@Component
@RequiredArgsConstructor
public class YooDiscordListener extends ListenerAdapter {
    private final DiscordBotToken discordBotToken;
    @PostConstruct
    public void init(){
        JDA jda = JDABuilder.createDefault(discordBotToken.getToken())
                .setActivity(Activity.playing("대기 중"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(this)
                .build();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User user = event.getAuthor();
        TextChannel textChannel = event.getChannel().asTextChannel();
        Message message = event.getMessage();

        log.info("get message: " + message.getContentDisplay());

        if(user.isBot()) return;
        if(message.getContentDisplay().equals("")){
            log.info("메세지 공백");
        }

        StringTokenizer stringTokenizer = new StringTokenizer(message.getContentDisplay());

        if(stringTokenizer.hasMoreTokens() && stringTokenizer.nextToken().equalsIgnoreCase("유재건")){
            while(stringTokenizer.hasMoreTokens()){
                String returnMessage = sendMessage(event, stringTokenizer.nextToken());
                textChannel.sendMessage(returnMessage).queue();

            }
        }
    }

    private String sendMessage(MessageReceivedEvent event, String message) {
        User user = event.getAuthor();
        switch (message){
            case "안녕" -> {
                return user.getName() + "님 안녕하세요 !";
            }
            case "배고파" ->{
                return user.getName() + " 또 배고파 ?";
            }
        }
        return "명령어 확인하세요잉";
    }
}
