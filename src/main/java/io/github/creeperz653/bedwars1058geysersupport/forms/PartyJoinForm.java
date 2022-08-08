package io.github.creeperz653.bedwars1058geysersupport.forms;

import com.andrei1058.bedwars.api.command.ParentCommand;
import com.andrei1058.bedwars.api.command.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.CustomForm;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.CustomFormResponse;
import org.geysermc.cumulus.response.SimpleFormResponse;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;
import java.util.List;
import org.bukkit.Bukkit;
import java.util.Arrays;
import java.util.UUID;
import com.andrei1058.bedwars.api.BedWars;

public class PartyJoinForm {

    public void formList(Player player) {

          BedWars bedwarsAPI = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();

        UUID uuid = player.getUniqueId();
        Player p = player;
        FloodgatePlayer floodgateplayer = FloodgateApi.getInstance().getPlayer(uuid);

        System.out.println("Player is a Floodgate player? " + (player != null));
        if (player == null) {

            p.sendMessage("You cannot execute this command.");
            return;

        }

        CustomForm joinMenu = CustomForm.builder()
                .title("Join party")
                .input("Join a player's party", "Username")
                .build();


        // response handler for joinMenu
        joinMenu.setResponseHandler((responseData) -> {
            CustomFormResponse response = joinMenu.parseResponse(responseData);
            if (!response.isCorrect()) {
                return;
            }

            String inputResponse = response.getInput(0);

            p.chat("/party accept " + inputResponse);

        });

                  floodgateplayer.sendForm(joinMenu);


    }

}
