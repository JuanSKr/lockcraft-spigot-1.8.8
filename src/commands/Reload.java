package commands;

import functionality.Main;
import org.bukkit.ChatColor;
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
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lPlugin has been successfully reloaded."));
                return true;
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lERROR!"));
                return false;
            }
        }
    }
}
