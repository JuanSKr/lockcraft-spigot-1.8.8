package commands;

import functionality.Main;
import messages.CommandMessages;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.ReloadCommand;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {

    private Main plugin;
    private Player player;

    public Reload(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)) {
            return false;
        } else {
            player = (Player) commandSender;
            if(command.getName().equalsIgnoreCase("lc-reload")) {
                plugin.reloadConfig();
                plugin.reloadPlayers();
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 2);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', CommandMessages.reloadMessage(plugin)));
                return true;
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('8', CommandMessages.commandNotExitsMessage(plugin)));
                return false;
            }
        }
    }
}
