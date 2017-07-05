package com.glenjendary.staffchat.events;

/* StaffChat Created by Glenjendary on 5/07/2017. */

import com.glenjendary.staffchat.Main;
import com.glenjendary.staffchat.commands.StaffChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChatToggle implements Listener {

    private Main plugin;
    public  StaffChatToggle (Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat (AsyncPlayerChatEvent event) {

        if (!(event.getPlayer() instanceof Player)) {
            return;
        }

        Player player = event.getPlayer();

        //Get the original message
        String msg = event.getMessage();

        //Create thew newmsg with prefix to differentiate
        String newmsg = ChatColor.BLUE + "[SC]" + msg;


                //Player is inStaffChat
        if (StaffChat.inStaffChat) {
                //Get all players
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                //Test if they should be able to see the message
                if (all.hasPermission("staffchat.enable")) {
                    //If they can, cancel the message and send the new one
                    //Since player has permission he will also see the message
                    event.setCancelled(true);
                    all.sendMessage(newmsg);
                } else {
                    //If they don't, cancel the message
                    event.setCancelled(true);
                }
            }
                    //Player isn't inStaffChat
        } else if (!(StaffChat.inStaffChat)) {
                    //Don't cancel message
            event.setCancelled(false);
        }

    }

}
