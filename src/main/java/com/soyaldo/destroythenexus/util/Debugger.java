package com.soyaldo.destroythenexus.util;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Debugger {

    private final JavaPlugin javaPlugin;
    private final ConsoleCommandSender consoleCommandSender;
    private boolean enable = false;
    private String prefix;

    public Debugger(JavaPlugin javaPlugin, String prefix ) {

        // Se establece el JavaPlugin.
        this.javaPlugin = javaPlugin;

        // Se establece el ConsoleCommandSender.
        consoleCommandSender = javaPlugin.getServer().getConsoleSender();

        // Se establece el prefijo.
        this.prefix = prefix;

    }

    /**
     * Establecer el estado del Debugger.
     * @param enable El nuevo estado del Debugger.
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * Verificar el estado del Debugger.
     * @return Verdadero si esta activado o falso si no.
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * Obtener el prefijo del debugger.
     * @return El prefijo.
     */
    public String getPrefix() {

        // Retornar el prefijo.
        return prefix;

    }

    /**
     * Establecer el nuevo prefijo para el debugger.
     * @param prefix El nuevo prefijo.
     */
    public void setPrefix( String prefix ) {

        // Se establece el prefijo.
        this.prefix = prefix;

    }

    public void info(String message ) {

        // Se llama al método con el prefijo desactivado.
        info( message , false );

    }

    public void info( String message , boolean prefixEnable ) {

        // Se llama al método generico con los parametros.
        generic( "&f" , message , prefixEnable );

    }

    public void warning( String message ) {

        // Se llama al método con el prefijo desactivado.
        warning( message , false );

    }

    public void warning( String message , boolean prefixEnable ) {

        // Se llama al método generico con los parametros.
        generic( "&6" , message , prefixEnable );

    }

    public void error( String message ) {

        // Se llama al método con el prefijo desactivado.
        error( message , false );

    }

    public void error( String message , boolean prefixEnable ) {

        // Se llama al método generico con los parametros.
        generic( "&c"  , message , prefixEnable );

    }

    public void generic( String messagePrefix , String message , boolean prefixEnable ) {

        // Si el debug esta desactivado.
        if ( ! enable )   return;
        // Se continua con el método.

        // Se crea un nuevo texto.
        String realMessage = messagePrefix + message;

        // Si el prefijo esta activado.
        if ( prefixEnable ) {

            // Se agrega el prefijo al mensaje real.
            realMessage = prefix + realMessage;

        }

        // Se aplica color al mensaje real.
        realMessage = ChatColor.translateAlternateColorCodes( '&' , realMessage );

        // Se envia el mensaje.
        consoleCommandSender.sendMessage( realMessage );

    }

}