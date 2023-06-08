package listener;

import functionality.RegisterPassword;
import inv.modifier.LoginInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import functionality.Main;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import utilities.GetNum;

public class LoginListener implements Listener {

    public static Main plugin;

    // All-args constructor

    public LoginListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void userJoined(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {
                registerInventory(player);
            }
        }.runTaskLater(plugin, 1L);
    }

    public static void registerInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Register"));
        LoginInventory.fillInventory(inv);
        plugin.addRegisterPass(player, 3);
        player.openInventory(inv);
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent event) {

        String pathInventory1 = ChatColor.translateAlternateColorCodes('&', "&6&lPIN: &7Register");
        String pathInventory2 = ChatColor.translateAlternateColorCodes('&', "&6&lPIN: &7Login");
        String pathInventory3 = ChatColor.translateAlternateColorCodes('&', "&6&lPIN: &7Modify");
        String pathinventory1M = ChatColor.stripColor(pathInventory1);
        String pathinventory2M = ChatColor.stripColor(pathInventory2);
        String pathinventory3M = ChatColor.stripColor(pathInventory3);

        boolean isRegister = false;
        boolean isLogged = false;
        boolean isModify = false;

        if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory1M)) {
            isRegister = true;
        } else if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory2M)) {
            isLogged = true;
        } else if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory3M)) {
            isModify = true;
        } else {
            return;
        }
        event.setCancelled(true);
        if (event.getCurrentItem() == null) {
            return;
        }
        if (event.getSlotType() == null) {
            return;
        } else {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory().equals(player.getOpenInventory().getTopInventory())) {
                int slot = event.getSlot();
                RegisterPassword pass = plugin.getRegisterPassword(player.getName());
                if ((slot >= 12 && slot <= 14) || (slot >= 21 && slot <= 23) || (slot >= 30 && slot <= 32)) {
                    int num = GetNum.getNumberSlot(slot);
                    if(pass != null) {
                        pass.addPassNum(num);
                        LoginInventory.setDecorationPass(event.getClickedInventory(), pass.getPass().length());


                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 10, 2);
                    }
                } else if(slot == 49) {
                    if(pass != null) {
                        pass.resetPass();
                        LoginInventory.resetDecorationPass(event.getClickedInventory());
                    }
                }
            }
        }
    }

    @EventHandler
    public void closeInventory(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Inventory inv = event.getInventory();
        if(plugin.getRegisterPassword(player.getName()) != null) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    player.openInventory(inv);
                }
            }, 1L);
        }

    }


}
