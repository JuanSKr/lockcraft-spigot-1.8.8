package commands;

import functionality.Main;
import messages.CommandMessages;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {

    private Main plugin;
    private Player player;

    public Help(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            CommandMessages.consoleCommandMessage(plugin);
            return false;
        } else {
            player = (Player) commandSender;
            if (command.getName().equalsIgnoreCase("lc-help")) {

                player.playSound(player.getLocation(), Sound.ANVIL_USE, 10, 2);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&m-------------&8[&f&lLock&6&lCraft&8]&f&m-------------"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7- &e/modifypin &8- &7Change your pin."));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-reload &8- &c(Admin) &7Reload plugin."));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&m-------------------------------------"));

                return true;
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('8', CommandMessages.commandNotExitsMessage(plugin)));
                return false;
            }
        }
    }
}
