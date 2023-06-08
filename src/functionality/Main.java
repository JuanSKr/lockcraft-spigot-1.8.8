package functionality;


import listener.LoginListener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    PluginDescriptionFile configReader = getDescription();
    protected String version = configReader.getVersion();

    public void onEnable() {
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