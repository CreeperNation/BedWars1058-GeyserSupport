package io.github.creeperz653.bedwars1058geysersupport;

import com.andrei1058.bedwars.api.BedWars;
import io.github.creeperz653.bedwars1058geysersupport.command.ShopFormCommand;
import io.github.creeperz653.bedwars1058geysersupport.command.PartyFormCommand;
import io.github.creeperz653.bedwars1058geysersupport.events.BedrockShopEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class bedwarsgeysersupport extends JavaPlugin {

    @Override
    public void onEnable() {

        // command = bgshop
        Objects.requireNonNull(this.getCommand("bgshop")).setExecutor(new ShopFormCommand());
        getServer().getPluginManager().registerEvents(new BedrockShopEvent(this), this);
        BedWars bedwarsAPI = Bukkit.getServicesManager().getRegistration(BedWars .class).getProvider();
        new PartyFormCommand(bedwarsAPI.getBedWarsCommand(), "party");
        new PartyFormCommand(bedwarsAPI.getBedWarsCommand(), "p");

    }


    public void onDisable () {
            getLogger().info("onDisable is called!");
        }

}
