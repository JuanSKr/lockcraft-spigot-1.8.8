package functionality;

import listener.LoginListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    protected PluginDescriptionFile configReader;
    protected String version;

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

}
