package com.glenjendary.staffchat.commands;

import com.glenjendary.staffchat.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* StaffChat Created by Glenjendary on 5/07/2017. */

public class StaffChat implements CommandExecutor {

    private Main plugin;

    public StaffChat (Main plugin) {
        this.plugin = plugin;
    }

    public static boolean inStaffChat = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
                //Check if it's the right command and the player sending it has the right permission
        if (cmd.getName().equalsIgnoreCase("staffchat") && player.hasPermission("staffchat.enable")) {
            //Check if the player isn't inStaffChat
            if (!inStaffChat) {
                //Make it so they are inStaffChat
                inStaffChat = true;
                //Send them a confirmation message
                player.sendMessage(ChatColor.GREEN + "You have toggle Staff Chat ON");
                //Check if the player is inStaffChat
            } else if (inStaffChat) {
                //Make it so they aren't inStaffChat
                inStaffChat = false;
                //Send them a confirmation message
                player.sendMessage(ChatColor.RED + "You have toggle Staff Chat OFF");
            }
        } else {
            //Error message, player doesn't have permissions
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            return false;
        }

        return true;
    }



}
