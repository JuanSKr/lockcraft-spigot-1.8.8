package messages;

import functionality.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CommandMessages {

    /**
     * Sends a message to the console indicating that a command cannot be run
     * from the console.
     *
     * @param plugin the main plugin instance
     */

    public static void consoleCommandMessage(Main plugin) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                plugin.NAME + "&c&lYou cannot run this command from the console."));
    }

    /**
     * Returns a String message indicating that the entered command does not exist.
     *
     * @param plugin the main plugin instance
     * @return a string representing an error message
     */

    public static String commandNotExitsMessage(Main plugin) {
        return plugin.NAME + "&c&lERROR: &7The command you have entered does not exist. " +
                "&7Use &f/help &7to get more information.";
    }

    /**
     * Returns a String message indicating that the plugin has been successfully reloaded.
     *
     * @param plugin the main plugin instance
     * @return a string representing a success message
     */

    public static String reloadMessage(Main plugin) {
        return plugin.NAME + "&aPlugin has been successfully reloaded.";
    }

    /**
     * Returns a String message indicating that the user does not have permission to use a command.
     *
     * @param plugin the main plugin instance
     * @return a string representing an error message
     */

    public static String noPermissions(Main plugin) {
        return plugin.NAME + "&cYou don't have permissions to use this command!";
    }

    /**
     * Returns a String representing the version of the plugin.
     *
     * @param plugin the main plugin instance
     * @return a string representing the plugin version
     */

    public static String showVersion(Main plugin) {
        return plugin.NAME + plugin.VERSION;
    }

}
