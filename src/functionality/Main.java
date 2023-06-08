package functionality;

import listener.LoginListener;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    protected PluginDescriptionFile configReader;
    protected String version;
    private ArrayList<RegisterPassword> passwords = new ArrayList<RegisterPassword>();

    public void onEnable() {
        getLogger().info("onEnable is being called!");

        configReader = getDescription();
        version = configReader.getVersion();

        registerEvents();
        registerCommands();

    }

    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public void registerCommands() {

    }

    public void registerEvents() {
        getLogger().info("registerEvents is being called!");

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new LoginListener(this), this);
    }

    public RegisterPassword getRegisterPassword(String player) {
        for(int i = 0; i<passwords.size(); i++) {
            if(passwords.get(i).getPlayer().getName().equals(player)) {
                return passwords.get(i);
            }
        }
        return null;
    }

    public void addRegisterPass(Player player, int maxAttempts) {
        passwords.add(new RegisterPassword(player, maxAttempts));
    }

    public void deleteRegisterPass(String player) {
        for(int i = 0; i < passwords.size(); i++) {
            if(passwords.get(i).getPlayer().getName().equals(player)) {
                passwords.remove(i);
            }
        }
    }

}
