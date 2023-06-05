package com.example.yoobot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DiscordBotToken {

    private  final String token;

    public DiscordBotToken(@Value("${discord.bot.token}") String discordBotToken) {
        this.token = discordBotToken;
    }

    public String getToken() {
        return token;
    }
}
