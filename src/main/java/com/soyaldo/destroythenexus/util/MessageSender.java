package com.soyaldo.destroythenexus.util;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class MessageSender {

    public static void sendMessage( Player player , Object message ) {
        sendMessage( player , message , new String[][]{} );
    }

    public static void sendMessage( Player player , Object message , String[][] replacements ) {
        if ( message.getClass().getSimpleName().equals( "String" ) ) {
            sendMessage( player , ( String ) message , replacements );
        } else {
            sendMessage( player , (List<String>) message , replacements );
        }
    }

    public static void sendMessage( Player player , List<String> messages ) {
        sendMessage( player , messages , new String[][]{} );
    }

    public static void sendMessage( Player player , List<String> messages , String[][] replacements ) {
        for ( String message : messages ) {
            sendMessage( player , message , replacements );
        }
    }

    public static void sendMessage( Player player , String message ) {
        sendMessage( player , message , new String[][]{} );
    }

    public static void sendMessage( Player player , String message , String[][] replacements ) {

        String finalMessage = PlaceholderAPI.setPlaceholders( player , message );

        for ( String[] replacement : replacements ) {
            finalMessage = finalMessage.replaceAll( replacement[0] , replacement[1] );
        }

        finalMessage = ChatColor.translateAlternateColorCodes( '&' , finalMessage );

        player.sendMessage( finalMessage );

    }

    public static void sendMessage( ConsoleCommandSender consoleCommandSender , Object message ) {
        sendMessage( consoleCommandSender , message , new String[][]{} );
    }

    public static void sendMessage( ConsoleCommandSender consoleCommandSender , Object message , String[][] replacements ) {
        if ( message.getClass().getSimpleName().equals( "String" ) ) {
            sendMessage( consoleCommandSender , ( String ) message , replacements );
        } else {
            sendMessage( consoleCommandSender , (List<String>) message , replacements );
        }
    }

    public static void sendMessage( ConsoleCommandSender consoleCommandSender , List<String> messages ) {
        sendMessage( consoleCommandSender , messages , new String[][]{} );
    }

    public static void sendMessage( ConsoleCommandSender consoleCommandSender , List<String> messages , String[][] replacements ) {
        for ( String message : messages ) {
            sendMessage( consoleCommandSender , message , replacements );
        }
    }

    public static void sendMessage( ConsoleCommandSender consoleCommandSender , String message ) {
        sendMessage( consoleCommandSender , message , new String[][]{} );
    }

    public static void sendMessage( ConsoleCommandSender consoleCommandSender , String message , String[][] replacements ) {

        String finalMessage = message;

        for ( String[] replacement : replacements ) {
            finalMessage = finalMessage.replaceAll( replacement[0] , replacement[1] );
        }

        finalMessage = ChatColor.translateAlternateColorCodes( '&' , finalMessage );

        consoleCommandSender.sendMessage( finalMessage );

    }

}