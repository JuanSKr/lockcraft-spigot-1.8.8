package messages;

import functionality.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CommandMessages {

    public static void consoleCommandMessage(Main plugin) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                plugin.NAME + "&c&lYou cannot run this command from the console."));
    }

    public static String commandNotExitsMessage(Main plugin) {
        return plugin.NAME + "&c&lERROR: &7The command you have entered does not exist. " +
                "&7Use &f/help &7to get more information.";
    }

    public static String reloadMessage(Main plugin) {
        return plugin.NAME + "&aPlugin has been successfully reloaded.";
    }

    public static String noPermissions(Main plugin) {
        return plugin.NAME + "&cYou don't have permissions to use this command!";
    }


}
