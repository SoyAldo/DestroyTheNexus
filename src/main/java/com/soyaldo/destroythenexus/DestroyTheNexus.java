package com.soyaldo.destroythenexus;

import com.soyaldo.destroythenexus.util.BrandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class DestroyTheNexus extends JavaPlugin {

    @Override
    public void onEnable() {
        BrandSender.sendVersionStatus( this, getServer().getConsoleSender(), "&aEnabled");

    }

    @Override
    public void onDisable() {
        BrandSender.sendVersionStatus( this, getServer().getConsoleSender(), "&cDisabled");
    }

}