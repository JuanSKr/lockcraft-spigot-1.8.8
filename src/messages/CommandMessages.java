package messages;

import functionality.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class CommandMessages {

    static String language = "Config.language";

    /**
     * Sends a message to the console indicating that a command cannot be run
     * from the console.
     *
     * @param plugin the main plugin instance
     */

    public static void consoleCommandMessage(Main plugin) {

        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.NAME + "&c&lYou cannot run this command from the console."));
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.NAME + "&c&lNo puedes ejecutar este comando desde la consola."));
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.NAME + "&c&lSie können diesen Befehl nicht über die Konsole ausführen."));
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.NAME + "&c&lYou cannot run this command from the console."));
        }
    }

    /**
     * Returns a String message indicating that the entered command does not exist.
     *
     * @param plugin the main plugin instance
     * @return a string representing an error message
     */

    public static String commandNotExitsMessage(Main plugin) {

        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return plugin.NAME + "&c&lERROR: &7The command you have entered does not exist. " +
                    "&7Use &f/help &7to get more information.";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return plugin.NAME + "&c&lERROR: &7Este comando no existe. " +
                    "&7Utiliza &f/help &7para obtener más información.";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return plugin.NAME + "&c&lERROR: &7Dieser Befehl existiert nicht. " +
                    "&7Verwenden Sie &f/help &7für weitere Informationen.";
        } else {
            return plugin.NAME + "&c&lERROR: &7The command you have entered does not exist. " +
                    "&7Use &f/help &7to get more information.";
        }
    }

    /**
     * Returns a String message indicating that the plugin has been successfully reloaded.
     *
     * @param plugin the main plugin instance
     * @return a string representing a success message
     */

    public static String reloadMessage(Main plugin) {

        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return plugin.NAME + "&aPlugin has been successfully reloaded.";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return plugin.NAME + "&aEl plugin ha sido recargado correctamente.";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return plugin.NAME + "&aDas Plugin wurde erfolgreich neu geladen.";
        } else {
            return plugin.NAME + "&aPlugin has been successfully reloaded.";
        }
    }

    /**
     * Returns a String message indicating that the user does not have permission to use a command.
     *
     * @param plugin the main plugin instance
     * @return a string representing an error message
     */

    public static String noPermissions(Main plugin) {

        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return plugin.NAME + "&cYou don't have permissions to use this command!";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return plugin.NAME + "&cNo tienes permisos para utilizar este comando!";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return plugin.NAME + "&cSie haben keine Berechtigung, diesen Befehl zu verwenden!";
        } else {
            return plugin.NAME + "&cYou don't have permissions to use this command!";
        }
    }

    /**
     * Returns a String representing the version of the plugin.
     *
     * @param plugin the main plugin instance
     * @return a string representing the plugin version
     */

    public static String showVersion(Main plugin) {
        return plugin.NAME + plugin.VERSIONSHOW;
    }

}
