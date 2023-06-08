package functionality;

import listener.LoginListener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    protected PluginDescriptionFile configReader;
    protected String version;

    public void onEnable() {
        configReader = getDescription();
        version = configReader.getVersion();

        registerCommands();
        registerEvents();
    }

    public void onDisable() {

    }

    public void registerCommands() {

    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new LoginListener(this), this);
    }

}
