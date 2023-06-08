package listener;

import functionality.RegisterPassword;
import inv.modifier.LoginInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
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
        FileConfiguration players = plugin.getPlayers();
        if (players.contains("Players." + player.getUniqueId() + ".pass")) {
            loginInventory(player);
        } else {
            inventoryDelay(player);
        }


    }


    public static void registerInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Login"));
        LoginInventory.fillInventory(inv);
        plugin.addRegisterPass(player, 3);
        player.openInventory(inv);
    }

    public static void loginInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Register"));
        LoginInventory.fillInventory(inv);
        plugin.addRegisterPass(player, 3);
        player.openInventory(inv);
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent event) {

        String pathInventory1 = ChatColor.translateAlternateColorCodes('&', "&6&lPIN: &7Register");
        String pathInventory2 = ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Login");
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
                    if (pass != null) {
                        pass.addPassNum(num);
                        LoginInventory.setDecorationPass(event.getClickedInventory(), pass.getPass().length());
                        if(pass.getPass().length() >= 5) {
                            FileConfiguration players = plugin.getPlayers();
                            String passString = pass.getPass();
                            if(isRegister) {
                                players.set("Players." + player.getUniqueId() + ".pass", passString);
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                        "&6&lPin registered! &7Your pass is &a&l" + passString));
                                plugin.deleteRegisterPass(player.getName());
                                player.closeInventory();
                                return;
                            } else if(isLogged) {
                                String userPass = players.getString("Players." + player.getUniqueId() + ".pass");
                                if(passString.equals(userPass)) {
                                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 2);
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                            "&a&lYou're logged in!"));
                                    plugin.deleteRegisterPass(player.getName());
                                    player.closeInventory();
                                    return;
                                } else {
                                    int attemps = pass.getAttempts();
                                    if(attemps <= 1) {
                                        plugin.deleteRegisterPass(player.getName());
                                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&',
                                                "&cYou have exceeded the attempt limit!"));
                                        return;
                                    } else {
                                        player.playSound(player.getLocation(), Sound.FIZZ, 10, 1);
                                        int maxAttempts = pass.getMaxAttempts();
                                        pass.reduceAttempts();
                                        LoginInventory.resetDecorationPass(event.getClickedInventory());
                                        pass.resetPass();
                                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&',
                                                "&c&lWrong pin! &8(&6"+(maxAttempts - attemps+1)+"&7/&6"+maxAttempts+"&8)"));
                                        return;
                                    }
                                }

                            } else if (isModify) {

                            }
                        }



                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 10, 2);
                    }
                } else if (slot == 49) {
                    if (pass != null) {
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
        if (plugin.getRegisterPassword(player.getName()) != null) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    player.openInventory(inv);
                }
            }, 1L);
        }

    }

    public void inventoryDelay(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                registerInventory(player);
            }
        }.runTaskLater(plugin, 1L);
    }


}
