package messages;

import functionality.Main;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class PinMessages {

    public static Main plugin;

    public PinMessages(Main plugin) {
        this.plugin = plugin;
    }

    /**
     * Returns a String message indicating that the maximum number of login attempts has been exceeded.
     *
     * @param plugin the main plugin instance
     * @return a string representing the exceeded attempts message
     */

    public static String exceededLimit(Main plugin) {
        return plugin.NAME + "&eToo many attempts! &8(&c3&7/&c3&8)";
    }

    /**
     * Returns a String message indicating that the maximum number of attempts to modify the pin has been exceeded.
     *
     * @param plugin the main plugin instance
     * @return a string representing the exceeded modification attempts message
     */

    public static String exceededLimitModify(Main plugin) {
        return plugin.NAME + "&eToo many attempts! &8(&c1&7/&c1&8)";
    }

    /**
     * Returns a String message indicating that the user has successfully logged in.
     *
     * @param plugin the main plugin instance
     * @return a string representing the successful login message
     */

    public static String userLogged(Main plugin) {
        return plugin.NAME + "&aYou're logged in!";
    }

    /**
     * Returns a String message indicating that the user's pin has been successfully registered.
     *
     * @param plugin the main plugin instance
     * @return a string representing the successful pin registration message
     */

    public static String pinRegistered(Main plugin, String passString) {
        return plugin.NAME + " " + playerPass(passString).toLegacyText();
    }

    /**
     * Returns a String message indicating that the user's current pin is correct and they can choose a new pin.
     *
     * @param plugin the main plugin instance
     * @return a string representing the correct pin message
     */

    public static String modifyCorrectPin(Main plugin) {
        return plugin.NAME + "&aCorrect PIN! &7Choose your new PIN.";
    }



    public static TextComponent playerPass(String passString) {
        TextComponent passwd = new TextComponent();

        passwd.setText(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes(
                '&', "&8[&f&lLock&6&lCraft&8] &ePIN successfully registered! &7Mouse over to view it."));
        passwd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(passString).
                color(net.md_5.bungee.api.ChatColor.GREEN).create()));
        return passwd;
    }

    public static TextComponent pinChanged(String passString) {
        TextComponent passwd = new TextComponent();

        passwd.setText(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes(
                '&', "&8[&f&lLock&6&lCraft&8] &ePIN successfully changed! &7Mouse over to view it."));
        passwd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(passString).
                color(net.md_5.bungee.api.ChatColor.GREEN).create()));
        return passwd;
    }

    public static String registerTxt() {
        return "&c&lRegister: &8Choose your PIN!";
    }

    public static String loginTxt() {
        return "&c&lLogin: &8Type your PIN!";
    }

    public static String modifyTxt() {
        return "&c&lModify: &8Choose your new PIN!";
    }

    public static String textYourActPin() {
        return "&aText your actually pin.";
    }

    public static String wrongPin() {
        return "&cWrong pin!";
    }

    public static String chooseYourNewPin() {
        return "&aChoose your new PIN.";
    }
}
