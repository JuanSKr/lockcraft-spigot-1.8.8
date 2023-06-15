package updates;

import functionality.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CheckUpdates {

    public static Main plugin;

    public CheckUpdates(Main plugin) {
        this.plugin = plugin;
    }

    public static void checkForUpdates() {
        try {
            // Dirección al archivo plugin.yml en GitHub
            URL url = new URL("https://raw.githubusercontent.com/JuanSKr/LockCraft-Spigot-1.8.8/e59aee615afeb7fd32e06364f597788f6448c328/src/plugin.yml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("version: ")) {
                    String latestVersion = line.split(": ")[1];
                    String currentVersion = plugin.VERSION;

                    if (!currentVersion.equalsIgnoreCase(latestVersion)) {
                        Bukkit.getConsoleSender().sendMessage(plugin.NAME + ChatColor.YELLOW + " A new version of the plugin is available: " + latestVersion);
                        Bukkit.getConsoleSender().sendMessage(plugin.NAME + ChatColor.YELLOW + " Update here:  "
                                + ChatColor.GREEN + "https://www.spigotmc.org/resources/lockcraft.110439/");
                    }
                    break;
                }
            }

            reader.close();
        } catch (IOException e) {
            plugin.getLogger().severe("Updates could not be verified: " + e.getMessage());
        }
    }

}
