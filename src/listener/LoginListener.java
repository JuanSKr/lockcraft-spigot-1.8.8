package listener;

import functionality.RegisterPassword;
import hash_code.Hash;
import inv.modifier.LoginInventory;
import messages.PinMessages;
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
    private static final String registerTxt = "&c&lRegister: &8Choose your PIN!";
    private static final String loginTxt = "&c&lLogin: &8Type your PIN!";
    private static final String modifyTxt = "&c&lModify: &8Choose your new PIN!";
    boolean notRegister = false;
    boolean notLogged = false;
    boolean isModify = false;

    //Constructor

    public LoginListener(Main plugin) {
        this.plugin = plugin;
    }

    /**
     * Listens for the PlayerJoinEvent and opens either a registration or login
     * inventory for the player. If the player's password is already stored in the
     * plugin's memory, a login inventory is opened; otherwise, a registration inventory
     * is opened.
     *
     * @param event the PlayerJoinEvent
     */

    @EventHandler
    public void userJoined(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration players = plugin.getPlayers();
        if (players.contains(playerPath(player))) {
            loginInventoryDelay(player);
        } else {
            registerInventoryDelay(player);
        }
    }

    /**
     * Creates and opens a registration inventory for the provided player. The
     * inventory is filled with a default set of items, and a RegisterPassword
     * is added to the plugin's memory for the player.
     *
     * @param player the player for whom the registration inventory should be opened
     */

    public static void registerInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', registerTxt));
        LoginInventory.fillInventory(inv);
        plugin.addRegisterPass(player, 3, false);
        player.openInventory(inv);
    }


    /**
     * Creates and opens a login inventory for the provided player. The inventory
     * is filled with a default set of items, and a RegisterPassword is added
     * to the plugin's memory for the player.
     *
     * @param player the player for whom the login inventory should be opened
     */

    public static void loginInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', loginTxt));
        LoginInventory.fillInventory(inv);
        plugin.addRegisterPass(player, 3, false);
        player.openInventory(inv);
    }

    /**
     * Creates and opens a modification inventory for the provided player. The
     * inventory is filled with a default set of items, a book is placed in the
     * middle of the inventory for the player to interact with, and a RegisterPassword
     * is added to the plugin's memory for the player.
     *
     * @param player the player for whom the modification inventory should be opened
     */

    public static void modifyInventory(Player player) {

        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', modifyTxt));
        LoginInventory.fillInventory(inv);
        plugin.addRegisterPass(player, 1, true);
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aText your actually pin."));
        item.setItemMeta(meta);
        inv.setItem(4, item);
        player.openInventory(inv);
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent event) {

        String pathInventory1 = ChatColor.translateAlternateColorCodes('&', registerTxt);
        String pathInventory2 = ChatColor.translateAlternateColorCodes('&', loginTxt);
        String pathInventory3 = ChatColor.translateAlternateColorCodes('&', modifyTxt);
        String pathinventory1M = ChatColor.stripColor(pathInventory1);
        String pathinventory2M = ChatColor.stripColor(pathInventory2);
        String pathinventory3M = ChatColor.stripColor(pathInventory3);

        if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory1M)) {
            notRegister = true;
        } else if (ChatColor.stripColor(event.getInventory().getName()).equals(pathinventory2M)) {
            notLogged = true;
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
                        if (pass.getPass().length() >= 5) {
                            FileConfiguration players = plugin.getPlayers();
                            String passString = pass.getPass();
                            if (notRegister) {
                                player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 2);
                                String hashedPass = Hash.getSHA256Hash(passString);
                                players.set(playerPath(player), hashedPass);
                                plugin.savePlayers();
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                        PinMessages.pinRegistered(plugin) + passString));
                                plugin.deleteRegisterPass(player.getName());
                                player.closeInventory();
                                return;
                            } else if (notLogged) {
                                String inputPassHash = Hash.getSHA256Hash(passString);
                                String storedPassHash = players.getString(playerPath(player));

                                if (inputPassHash.equals(storedPassHash)) {
                                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 2);
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', PinMessages.userLogged(plugin)));
                                    plugin.deleteRegisterPass(player.getName());
                                    player.closeInventory();
                                    return;
                                } else {
                                    int attemps = pass.getAttempts();
                                    if (attemps <= 1) {
                                        plugin.deleteRegisterPass(player.getName());
                                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', PinMessages.exceededLimit(plugin)));
                                        return;
                                    } else {
                                        player.playSound(player.getLocation(), Sound.FIZZ, 10, 1);
                                        int maxAttempts = pass.getMaxAttempts();
                                        pass.reduceAttempts();
                                        LoginInventory.resetDecorationPass(event.getClickedInventory());
                                        pass.resetPass();
                                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                                plugin.NAME + "&cWrong pin! &8(&6" + (maxAttempts - attemps + 1) + "&7/&6" + maxAttempts + "&8)"));
                                        return;
                                    }
                                }

                            } else if (isModify) {
                                int stage = pass.getStage();
                                if (stage == 1) {
                                    String inputPassHash = Hash.getSHA256Hash(passString);
                                    String storedPassHash = players.getString(playerPath(player));

                                    if (inputPassHash.equals(storedPassHash)) {
                                        newPinModify(event, player, pass);
                                    } else {
                                        plugin.deleteRegisterPass(player.getName());
                                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', PinMessages.exceededLimitModify(plugin)));
                                    }

                                } else {
                                    saveNewPin(players, player, passString);
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

    /**
     * Listens for the InventoryCloseEvent and reopens the inventory for the player
     * if they have a RegisterPassword in the plugin's memory. This reopening is
     * scheduled with a small delay to ensure correct timing in the server's tick
     * cycle. A sound is also played when the inventory is reopened.
     *
     * @param event the InventoryCloseEvent
     */

    @EventHandler
    public void closeInventory(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Inventory inv = event.getInventory();
        if (plugin.getRegisterPassword(player.getName()) != null) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    player.playSound(player.getLocation(), Sound.BLAZE_HIT, 10, 2);
                    player.openInventory(inv);
                }
            }, 1L);
        }
    }

    /**
     * Schedules the opening of a register inventory for a player with a small
     * delay. The delay is useful for ensuring that the inventory opens at the
     * correct time in the server's tick cycle.
     *
     * @param player the player for whom the register inventory should be opened
     */

    public void registerInventoryDelay(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                registerInventory(player);
            }
        }.runTaskLater(plugin, 1L);
    }

    /**
     * Schedules the opening of a login inventory for a player with a small
     * delay. The delay is useful for ensuring that the inventory opens at the
     * correct time in the server's tick cycle.
     *
     * @param player the player for whom the login inventory should be opened
     */

    public void loginInventoryDelay(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                loginInventory(player);
            }
        }.runTaskLater(plugin, 1L);
    }

    /**
     * Listens for the PlayerQuitEvent and deletes the registering password of the
     * player from the plugin's memory.
     *
     * @param event the PlayerQuitEvent
     */

    @EventHandler
    public void thenLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        plugin.deleteRegisterPass(player.getName());
    }

    /**
     * Returns a String that represents the path of a player's password in a
     * configuration file. The path is formed by appending the player's unique ID
     * to the string "Players.".
     *
     * @param player the player whose path needs to be found
     * @return a string representing the player's path
     */

    public String playerPath(Player player) {
        return "Players." + player.getUniqueId() + ".pass";
    }

    /**
     * Handles a click event in an inventory and proceeds to the next stage of
     * password modification. The method resets the inventory, informs the player,
     * and places a book in the middle of the inventory for the player to interact
     * with.
     *
     * @param event the InventoryClickEvent
     * @param player the player clicking in the inventory
     * @param pass the password register instance
     */

    public void newPinModify(InventoryClickEvent event, Player player, RegisterPassword pass) {
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 2);
        pass.increaseStage();
        LoginInventory.resetDecorationPass(event.getClickedInventory());
        pass.resetPass();
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', PinMessages.modifyCorrectPin(plugin)));
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aChoose your new PIN."));
        item.setItemMeta(meta);
        event.getClickedInventory().setItem(4, item);
    }

    /**
     * Saves the new password provided by the player in the configuration file.
     * This method hashes the password, sets it in the configuration file,
     * saves the file, and then deletes the password from the plugin's memory.
     *
     * @param players the configuration file where the password is stored
     * @param player the player whose password is being modified
     * @param passString the new password entered by the player
     */

    public void saveNewPin(FileConfiguration players, Player player, String passString) {
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 1);
        String hashedPass = Hash.getSHA256Hash(passString);
        players.set(playerPath(player), hashedPass);
        plugin.savePlayers();
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                PinMessages.pinChanged(plugin) + passString + "."));
        plugin.deleteRegisterPass(player.getName());
        player.closeInventory();
    }
}