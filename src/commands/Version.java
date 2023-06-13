package commands;

import functionality.Main;
import messages.CommandMessages;
import net.minecraft.server.v1_8_R3.CommandMe;
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

    /**
     * Handles a command from a CommandSender object. This method checks if the
     * sender is a player and if the command issued is "lc-version".
     *
     * If the sender is not a player, the method sends the console a message
     * indicating the command can't be used in the console and returns false.
     *
     * If the sender is a player but issues a command other than "lc-version",
     * the player is informed that the command does not exist and the method
     * returns false.
     *
     * If the player issues the "lc-version" command, the method plays a sound,
     * sends the player a version message, and returns true.
     *
     * @param commandSender the sender of the command
     * @param command the issued command
     * @param label the alias of the command which was used
     * @param args an array of additional arguments passed to the command
     * @return a boolean indicating whether the command was handled successfully
     */

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
