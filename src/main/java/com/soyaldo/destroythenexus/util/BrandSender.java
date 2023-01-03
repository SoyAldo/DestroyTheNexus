package com.soyaldo.destroythenexus.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class BrandSender {

    public static void sendVersion(JavaPlugin javaPlugin, CommandSender commandSender) {
        sendVersionStatus(javaPlugin, commandSender, "");
    }

    public static void sendVersionStatusFromConsole( JavaPlugin javaPlugin , String status ) {
        sendVersionStatus( javaPlugin , javaPlugin.getServer().getConsoleSender(), status);
    }

    public static void sendVersionStatus(JavaPlugin javaPlugin, CommandSender commandSender, String status) {
        List<String> versionStatus = new ArrayList<>();
        versionStatus.add("&3*");
        versionStatus.add("&3* " + javaPlugin.getDescription().getName() + " " + status);
        versionStatus.add("&3*");
        versionStatus.add("&3* &bVersion: &f" + javaPlugin.getDescription().getVersion());
        versionStatus.add("&3* &bAuthor: &f" + javaPlugin.getDescription().getAuthors().get(0));
        versionStatus.add("&3* &bWebsite: &f" + javaPlugin.getDescription().getWebsite());
        versionStatus.add("&3*");
        versionStatus.add("&3* &bI like the bread!");
        versionStatus.add("&3*");
        for(String text : versionStatus) commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }

}