package io.github.creeperz653.bedwars1058geysersupport.command;


import io.github.creeperz653.bedwars1058geysersupport.forms.ShopForm;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ShopFormCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED +"Console got no permission for this command");
            return true;
        }
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("bgshop") && player.hasPermission("bg.shop")) {

            new ShopForm().formList(player);

        }
        return true;
    }
}
