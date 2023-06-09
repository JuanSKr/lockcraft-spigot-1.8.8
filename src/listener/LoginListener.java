package listener;

import functionality.RegisterPassword;
import hash_code.Hash;
import inv.modifier.LoginInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import functionality.Main;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import utilities.GetNum;

public class LoginListener implements Listener {

    public static Main plugin;
    boolean isRegister = false;
    boolean isLogged = false;
    boolean isModify = false;

    // All-args constructor

    public LoginListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void userJoined(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration players = plugin.getPlayers();
        if (players.contains("Players." + player.getUniqueId() + ".pass")) {
            loginInventoryDelay(player);
        } else {
            registerInventoryDelay(player);
        }

    }

    public static void registerInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6&lPIN: &7Register"));
        LoginInventory.fillInventory(inv);
        plugin.addRegisterPass(player, 3, false);
        player.openInventory(inv);
    }

    public static void loginInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Login"));
        LoginInventory.fillInventory(inv);
        plugin.addRegisterPass(player, 3, false);
        player.openInventory(inv);
    }

    public static void modifyInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&6&lPIN: &7Modify"));
        LoginInventory.fillInventory(inv);
        plugin.addRegisterPass(player, 1, true);
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aText your actually pin."));
        item.setItemMeta(meta);
        inv.setItem(4, item);
        player.openInventory(inv);
    }

    public void setPathInventory(String pathinventory1M, String pathinventory2M, String pathinventory3M, InventoryClickEvent event) {
        if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory1M)) {
            isRegister = true;
        } else if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory2M)) {
            isLogged = true;
        } else if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory3M)) {
            isModify = true;
        } else {
            return;
        }
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        RegisterPassword pass = plugin.getRegisterPassword(player.getName());

        String pathInventory1 = ChatColor.translateAlternateColorCodes('&', "&6&lPIN: &7Register");
        String pathInventory2 = ChatColor.translateAlternateColorCodes('&', "&6PIN: &7Login");
        String pathInventory3 = ChatColor.translateAlternateColorCodes('&', "&6&lPIN: &7Modify");
        String pathinventory1M = ChatColor.stripColor(pathInventory1);
        String pathinventory2M = ChatColor.stripColor(pathInventory2);
        String pathinventory3M = ChatColor.stripColor(pathInventory3);

        setPathInventory(pathinventory1M, pathinventory2M, pathinventory3M, event);

        event.setCancelled(true);
        if (event.getCurrentItem() == null) {
            return;
        }
        if (event.getSlotType() == null) {
            return;
        } else {

            if (event.getClickedInventory().equals(player.getOpenInventory().getTopInventory())) {
                int slot = event.getSlot();

                if ((slot >= 12 && slot <= 14) || (slot >= 21 && slot <= 23) || (slot >= 30 && slot <= 32)) {
                    int num = GetNum.getNumberSlot(slot);
                    if (pass != null) {
                        pass.addPassNum(num);
                        LoginInventory.setDecorationPass(event.getClickedInventory(), pass.getPass().length());
                        if(pass.getPass().length() >= 5) {
                            FileConfiguration players = plugin.getPlayers();
                            String passString = pass.getPass();
                            if(isRegister) {
                                player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 2);
                                String hashedPass = Hash.getSHA256Hash(passString);
                                players.set("Players." + player.getUniqueId() + ".pass", hashedPass);
                                plugin.savePlayers();
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                        "&6&lPin registered! &7Your pass is &a&l" + passString));
                                plugin.deleteRegisterPass(player.getName());
                                player.closeInventory();
                                return;
                            } else if(isLogged) {
                                String inputPassHash = Hash.getSHA256Hash(passString);
                                String storedPassHash = players.getString("Players." + player.getUniqueId() + ".pass");

                                if(inputPassHash.equals(storedPassHash)) {
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
                                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                                "&c&lWrong pin! &8(&6"+(maxAttempts - attemps+1)+"&7/&6"+maxAttempts+"&8)"));
                                        return;
                                    }
                                }

                            } else if (isModify) {
                                int stage = pass.getStage();
                                if(stage == 1) {
                                    String inputPassHash = Hash.getSHA256Hash(passString);
                                    String storedPassHash = players.getString("Players." + player.getUniqueId() + ".pass");

                                    if(inputPassHash.equals(storedPassHash)) {
                                        player.playSound(player.getLocation(), Sound.DOOR_OPEN, 10, 2);
                                        pass.increaseStage();
                                        LoginInventory.resetDecorationPass(event.getClickedInventory());
                                        pass.resetPass();
                                        ItemStack item = new ItemStack(Material.BOOK);
                                        ItemMeta meta = item.getItemMeta();
                                        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aText your new pin."));
                                        item.setItemMeta(meta);
                                        event.getClickedInventory().setItem(4, item);

                                    } else {
                                        plugin.deleteRegisterPass(player.getName());
                                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&',
                                                "&cYou have exceeded the attempt limit!"));
                                    }

                                } else {
                                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 2);
                                    String hashedPass = Hash.getSHA256Hash(passString);
                                    players.set("Players." + player.getUniqueId() + ".pass", hashedPass);
                                    plugin.savePlayers();
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                            "&6&lYour PIN has been successfully modified! &7Your new PIN is &a&l" + passString));
                                    plugin.deleteRegisterPass(player.getName());
                                    player.closeInventory();
                                    return;
                                }
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

    public void registerInventoryDelay(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                registerInventory(player);
            }
        }.runTaskLater(plugin, 1L);
    }

    public void loginInventoryDelay(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                loginInventory(player);
            }
        }.runTaskLater(plugin, 1L);
    }


    @EventHandler
    public void thenLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        plugin.deleteRegisterPass(player.getName());
    }


}
