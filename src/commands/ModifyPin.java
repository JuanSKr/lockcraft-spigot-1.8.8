package commands;

import listener.LoginListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModifyPin implements CommandExecutor {

    /**
     * Handles the execution of a specific command sent by a command sender. This command
     * is meant to be used by a player; if the command sender is not a player, the method
     * does nothing and returns false.
     * If the command sender is a player, it modifies their inventory by calling the
     * modifyInventory method from the LoginListener class.
     *
     * @param commandSender the entity that sent the command
     * @param command the command to execute
     * @param label an alias of the command
     * @param args the arguments provided with the command
     * @return true if the command sender is a player, false otherwise
     */

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;
        LoginListener.modifyInventory(player);
        return true;
    }
}
