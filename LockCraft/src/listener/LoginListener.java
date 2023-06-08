package listener;

import inv.modifier.LoginInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import functionality.Main;
import org.bukkit.inventory.Inventory;

public class LoginListener implements Listener {

    public Main plugin;

    // All-args constructor

    public LoginListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void userJoined(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        registerInventory(player, plugin);


    }

    public static void registerInventory(Player player, Main plugin) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Registro"));
        LoginInventory.fillInventory(inv);
        player.openInventory(inv);
    }


}
