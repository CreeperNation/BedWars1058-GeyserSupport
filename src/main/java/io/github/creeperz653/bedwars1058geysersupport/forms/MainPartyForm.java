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
import io.github.creeperz653.bedwars1058geysersupport.forms.PartyManageForm;

public class MainPartyForm {

    public void formList(Player player) {

          BedWars bedwarsAPI = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();
        Player p = player;
        UUID uuid = player.getUniqueId();
        FloodgatePlayer floodgateplayer = FloodgateApi.getInstance().getPlayer(uuid);

        System.out.println("Player is a Floodgate player? " + (player != null));
        if (player == null) {

            p.sendMessage("You cannot execute this command.");
            return;

        }

        if (bedwarsAPI.getPartyUtil().isOwner(p) == true) {

            Player owner = (Player) player;

        } else {

            System.out.println("Player is not a party owner");

        }


        // Menu for people in a party.
        SimpleForm partyMenu = SimpleForm.builder()
                .title("Party Menu")
                .button("Manage Party")
                .button("Leave Party")
                .build();

        // Menu for people who aren't in a party.
        SimpleForm partyMenu2 = SimpleForm.builder()
                .title("Party Menu")
                .button("Join a Party")
                .button("Invite")
                .build();

        // response handler for partyMenu if player is not in a party
        partyMenu2.setResponseHandler((responseData) -> {
            SimpleFormResponse response = partyMenu2.parseResponse(responseData);
            if (!response.isCorrect()) {
                return;
            }

            int button = response.getClickedButtonId();

            if (button == 0) {

                new PartyJoinForm().formList(player);

            }

            if (button == 1) {

                new PartyInviteForm().formList(player);

            }


        });


        // response handler for partyMenu if player is in a party
        partyMenu.setResponseHandler((responseData) -> {
            SimpleFormResponse response = partyMenu.parseResponse(responseData);
            if (!response.isCorrect()) {
                return;
            }

            int button = response.getClickedButtonId();

            if (button == 0) {

                new PartyManageForm().formList(player);

            }

            if (button == 1) {

                p.chat("/party disband");

            }


        });


        if (bedwarsAPI.getPartyUtil().hasParty(p)) {

            Player owner = null;
            if (bedwarsAPI.getPartyUtil().isOwner(p) == true) {

                owner = (Player) player;

            } else {

                System.out.println("Player is not a party owner");

            }

            floodgateplayer.sendForm(partyMenu);
            System.out.println(bedwarsAPI.getPartyUtil().getMembers(owner));
        } else {

            floodgateplayer.sendForm(partyMenu2);

        }

    }

}
