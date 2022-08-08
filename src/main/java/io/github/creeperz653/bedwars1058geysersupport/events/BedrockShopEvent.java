package io.github.creeperz653.bedwars1058geysersupport.events;

import com.andrei1058.bedwars.api.events.shop.ShopOpenEvent;
import io.github.creeperz653.bedwars1058geysersupport.bedwarsgeysersupport;
import io.github.creeperz653.bedwars1058geysersupport.forms.ShopForm;
import io.github.creeperz653.bedwars1058geysersupport.utils.CheckJavaOrFloodPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

public class BedrockShopEvent implements Listener {

    private bedwarsgeysersupport plugin;

    public BedrockShopEvent(bedwarsgeysersupport plugin) {
        this.plugin = plugin;
        // plugin.getCommand("bw GeyserShopForm").setExecutor(this);
    }

    @EventHandler
    public void onShopOpen(ShopOpenEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        boolean isFloodgatePlayer = CheckJavaOrFloodPlayer.isFloodgatePlayer(uuid);
        if (isFloodgatePlayer) {
            event.setCancelled(true);
            new ShopForm().formList(event.getPlayer());
        }

    }

    }


