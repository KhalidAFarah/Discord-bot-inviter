package com.example.inviter.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class DiscordEvents extends ListenerAdapter {
    List<String> codes;


    public DiscordEvents(List<String> codes){
        this.codes = codes;
    }

    public void onMessageReceived(MessageReceivedEvent event){
        for(int i = 0; i < codes.size(); i++){
            if(codes.get(i).equals(event.getMessage().getContentDisplay())){
                codes.remove(i);
                event.getTextChannel().sendMessage("correct code").queue();
            }
        }

        if(codes.size() == 0){
            CodeGenerator.fillList(codes, 50);
        }
    }
}
