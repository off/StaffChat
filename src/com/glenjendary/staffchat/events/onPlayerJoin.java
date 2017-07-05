package com.glenjendary.staffchat.events;

import com.glenjendary.staffchat.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/* StaffChat Created by Glenjendary on 5/07/2017. */

public class onPlayerJoin implements Listener {

    private Main plugin;
    public onPlayerJoin(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {

        Player player = event.getPlayer();
                                                                                    //Hey, that's me!
        if (player.getUniqueId().toString().replace("-", "") == "e06c919d712b408a8fff3bd16512ee12") {
            player.sendMessage(ChatColor.GREEN + "This server is running your StaffChat Plugin");
        }

    }

}
