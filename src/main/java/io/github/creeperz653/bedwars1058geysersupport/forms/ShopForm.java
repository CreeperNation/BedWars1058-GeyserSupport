package io.github.creeperz653.bedwars1058geysersupport.forms;


import io.github.creeperz653.bedwars1058geysersupport.utils.CheckJavaOrFloodPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.SimpleFormResponse;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.UUID;

public class ShopForm {

    public void formList(Player player) {
        UUID uuid = player.getUniqueId();
        boolean isFloodgatePlayer = CheckJavaOrFloodPlayer.isFloodgatePlayer(uuid);
        if (isFloodgatePlayer) {
            FloodgatePlayer fPlayer = FloodgateApi.getInstance().getPlayer(uuid);

            fPlayer.sendForm(

                    SimpleForm.builder()
                            .title(ChatColor.DARK_AQUA + ("Shop Title"))
                            .content(ChatColor.ITALIC + ("Future items"))
                            .button(ChatColor.DARK_AQUA + ("Future items"))
                            .button(ChatColor.DARK_AQUA + ("Future items"))
                            .button(ChatColor.DARK_AQUA + ("Future items"))
                            .button(ChatColor.DARK_AQUA + ("Future items"))
                            .button(ChatColor.DARK_AQUA + ("Future items"))
                            .responseHandler((form, responseData) -> {
                                SimpleFormResponse response = form.parseResponse(responseData);
                                if (!response.isCorrect()) {
                                    // player closed the form or returned invalid info (see FormResponse)
                                    return;
                                }
                            }).build());
        }
    }
}