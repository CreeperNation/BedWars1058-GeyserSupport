package io.github.creeperz653.bedwars1058geysersupport.command;
import com.andrei1058.bedwars.api.command.ParentCommand;
import com.andrei1058.bedwars.api.command.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
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
import  io.github.creeperz653.bedwars1058geysersupport.forms.JoinForm;
import  io.github.creeperz653.bedwars1058geysersupport.forms.InviteForm;
import  io.github.creeperz653.bedwars1058geysersupport.forms.MainPartyForm;

public class PartyFormCommand extends SubCommand {

    BedWars bedwarsAPI = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();

    public PartyCommand(ParentCommand parent, String name) {
        super(parent, name);

        showInList(true);

        setPriority(14);

        setArenaSetupCommand(false);
    }


    @Override
    public boolean execute(String[] args, CommandSender s) {


        Player p = (Player) s;

        if (!(s instanceof Player)) {
            s.sendMessage(ChatColor.RED +"This command can only be executed as a player.");
            return true;
        }
        Player player = (Player) s;
            new MainPartyForm().formList(player);
        return true;

    }

    @Override
    public List<String> getTabComplete() {
        return null;
    }
}
