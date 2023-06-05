package com.example.yoobot;

import com.example.yoobot.config.DiscordBotToken;
import com.example.yoobot.listener.YooDiscordListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class YoobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoobotApplication.class, args);

    }

}
