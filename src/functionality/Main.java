package functionality;

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

    public void onEnable() {
        getLogger().info("onEnable is being called!");

        configReader = getDescription();
        version = configReader.getVersion();

        registerEvents();
        registerCommands();
        registerPlayers();

    }

    public void onDisable() {
        HandlerList.unregisterAll(this);
        if (players != null) {
            this.savePlayers();
        }
    }

    public void registerCommands() {

    }

    public void registerEvents() {
        getLogger().info("registerEvents is being called!");

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new LoginListener(this), this);
    }

    public RegisterPassword getRegisterPassword(String player) {
        for (int i = 0; i < passwords.size(); i++) {
            if (passwords.get(i).getPlayer().getName().equals(player)) {
                return passwords.get(i);
            }
        }
        return null;
    }

    public void addRegisterPass(Player player, int maxAttempts) {
        passwords.add(new RegisterPassword(player, maxAttempts));
    }

    public void deleteRegisterPass(String player) {
        for (int i = 0; i < passwords.size(); i++) {
            if (passwords.get(i).getPlayer().getName().equals(player)) {
                passwords.remove(i);
            }
        }
    }

    public void registerPlayers() {
        playersFile = new File(this.getDataFolder(), "players.yml");
        if (!playersFile.exists()) {
            this.getPlayers().options().copyDefaults(true);
            savePlayers();
        }
    }

    public void savePlayers() {
        try {
            players.save(playersFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getPlayers() {
        if (players == null) {
            reloadPlayers();
        }
        return players;
    }

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
