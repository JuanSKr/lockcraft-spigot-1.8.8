package functionality;

import commands.ModifyCommand;
import listener.LoginListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.ArrayList;

public class Main extends JavaPlugin {

    protected PluginDescriptionFile configReader;
    protected String version;
    private ArrayList<RegisterPassword> passwords = new ArrayList<RegisterPassword>();
    private FileConfiguration players = null;
    private File playersFile = null;

    /**
     * This method is called when the plugin is enabled.
     * It's responsible for initializing key components such as the config reader,
     * setting the plugin version, and registering events, commands, and players.
     * This method is a critical part of the plugin lifecycle and is
     * automatically called by the server when the plugin is being enabled.
     */

    public void onEnable() {
        getLogger().info("onEnable is being called!");

        configReader = getDescription();
        version = configReader.getVersion();

        registerEvents();
        registerCommands();
        registerPlayers();

    }

    /**
     * This method is called when the plugin is disabled.
     * It unregisters all the events, and if the players list is not null, it saves the players.
     * This method is a critical part of the plugin lifecycle and is
     * automatically called by the server when the plugin is being disabled.
     */

    public void onDisable() {
        HandlerList.unregisterAll(this);
        if (players != null) {
            this.savePlayers();
        }
    }

    public void registerCommands() {
        this.getCommand("modifypin").setExecutor(new ModifyCommand());
    }

    /**
     * This method is responsible for registering all necessary events.
     * It's typically called during the enabling of the plugin.
     * Specifically, it registers an instance of the LoginListener class.
     */

    public void registerEvents() {
        getLogger().info("registerEvents is being called!");

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new LoginListener(this), this);
    }

    /**
     * This method retrieves the RegisterPassword object associated with the provided player.
     *
     * @param player  The name of the player for which to retrieve the RegisterPassword object.
     * @return The RegisterPassword object associated with the given player, or null if no such object exists.
     */

    public RegisterPassword getRegisterPassword(String player) {
        for (int i = 0; i < passwords.size(); i++) {
            if (passwords.get(i).getPlayer().getName().equals(player)) {
                return passwords.get(i);
            }
        }
        return null;
    }

    /**
     * This method adds a new RegisterPassword object to the passwords list for the provided player.
     * The RegisterPassword object is initialized with the given maximum number of attempts.
     *
     * @param player       The player to add a RegisterPassword object for.
     * @param maxAttempts  The maximum number of login attempts the player should have.
     */

    public void addRegisterPass(Player player, int maxAttempts, boolean modifiying) {
        passwords.add(new RegisterPassword(player, maxAttempts, modifiying));
    }

    /**
     * This method removes the RegisterPassword object associated with the provided player.
     * The method iterates through the passwords list and removes the RegisterPassword object
     * if its associated player matches the provided player name.
     *
     * @param player  The name of the player for which to remove the RegisterPassword object.
     */

    public void deleteRegisterPass(String player) {
        for (int i = 0; i < passwords.size(); i++) {
            if (passwords.get(i).getPlayer().getName().equals(player)) {
                passwords.remove(i);
            }
        }
    }

    /**
     * Checks for the existence of the "players.yml" file in the plugin's data folder.
     * If the file does not exist, it creates a new file with default options and saves it.
     */

    public void registerPlayers() {
        playersFile = new File(this.getDataFolder(), "players.yml");
        if (!playersFile.exists()) {
            this.getPlayers().options().copyDefaults(true);
            savePlayers();
        }
    }

    /**
     * Attempts to save the players' data to the "players.yml" file.
     * If an IOException is encountered, the stack trace is printed to the console.
     */

    public void savePlayers() {
        try {
            players.save(playersFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the FileConfiguration object for the players' data.
     * If the FileConfiguration object is null, it attempts to reload the data from the file before returning.
     *
     * @return FileConfiguration object for the players' data.
     */

    public FileConfiguration getPlayers() {
        if (players == null) {
            reloadPlayers();
        }
        return players;
    }

    /**
     * Reloads the players' data from the "players.yml" file.
     * If the FileConfiguration object for the players' data is null, a new File object is created to represent "players.yml".
     * The players' data is then loaded from the file into the FileConfiguration object.
     * Additionally, it sets the default configuration from a UTF-8 encoded 'players.yml' resource file, if such a file exists.
     * If an UnsupportedEncodingException is encountered, the stack trace is printed to the console.
     */

    public void reloadPlayers() {
        if (players == null) {
            playersFile = new File(getDataFolder(), "players.yml");
        }
        players = YamlConfiguration.loadConfiguration(playersFile);

        Reader defConfigStream;
        try {
            defConfigStream = new InputStreamReader(this.getResource("players.yml"), "UTF8");
            if (defConfigStream != null) {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                players.setDefaults(defConfig);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
