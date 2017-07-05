package com.glenjendary.staffchat;

/* StaffChat Created by Glenjendary on 5/07/2017. */

import com.glenjendary.staffchat.commands.StaffChat;
import com.glenjendary.staffchat.events.StaffChatToggle;
import com.glenjendary.staffchat.events.onPlayerJoin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public void onEnable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        registerCommands();
        registerEvents();

        logger.info(pdfFile.getName() + " has been enabled with version "
                + pdfFile.getVersion());
    }

    public void registerCommands() {

        getCommand("staffchat").setExecutor(new StaffChat(this));

    }

    public void registerEvents() {

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new StaffChatToggle(this), this);
        pm.registerEvents(new onPlayerJoin(this), this);

    }

    public void onDisable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        logger.info(pdfFile.getName() + " has been disabled with version "
                + pdfFile.getVersion());

    }

}
