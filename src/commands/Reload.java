package commands;

import functionality.Main;
import messages.CommandMessages;
import org.bukkit.Bukkit;
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

    /**
     * Handles a command from a CommandSender object. This method checks if the
     * sender is a player and if the command issued is "lc-reload".
     *
     * If the sender is not a player, the method returns false.
     * If the sender is a player but does not have the "op" status or
     * issues a command other than "lc-reload", the player is informed
     * accordingly, and the method returns false.
     *
     * If the player issues the "lc-reload" command and has "op" status,
     * the method reloads the plugin's configuration, reloads players,
     * plays a sound, sends the player and console a reload message,
     * and returns true.
     *
     * @param commandSender the sender of the command
     * @param command the issued command
     * @param label the alias of the command which was used
     * @param args an array of additional arguments passed to the command
     * @return a boolean indicating whether the command was handled successfully
     */

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)) {
            return false;
        } else {
            player = (Player) commandSender;
            if(command.getName().equalsIgnoreCase("lc-reload")) {
                if(player.isOp()) {
                    plugin.reloadConfig();
                    plugin.reloadPlayers();
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 2);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', CommandMessages.reloadMessage(plugin)));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', CommandMessages.reloadMessage(plugin)));
                    return true;
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', CommandMessages.noPermissions(plugin)));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.NAME +
                            "&f" + player.getName() + " &etried to use &c&llc-reload&e."));
                    return false;
                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('8', CommandMessages.commandNotExitsMessage(plugin)));
                return false;
            }
        }
    }
}
