package commands;

import functionality.Main;
import messages.CommandMessages;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Version implements CommandExecutor {

    private Main plugin;
    private Player player;

    public Version(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            CommandMessages.consoleCommandMessage(plugin);
            return false;
        } else {
            player = (Player) commandSender;
            if (command.getName().equalsIgnoreCase("lc-version")) {

                player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 2);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', CommandMessages.showVersion(plugin)));
                return true;
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('8', CommandMessages.commandNotExitsMessage(plugin)));
                return false;
            }
        }
    }
}
