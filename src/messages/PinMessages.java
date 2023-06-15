package messages;

import functionality.Main;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.configuration.file.FileConfiguration;

public class PinMessages {

    static String language = "Config.language";

    /**
     * Returns a String message indicating that the maximum number of login attempts has been exceeded.
     *
     * @param plugin the main plugin instance
     * @return a string representing the exceeded attempts message
     */

    public static String exceededLimit(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return plugin.NAME + "&eToo many attempts! &8(&c3&7/&c3&8)";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return plugin.NAME + "&eHas superado el límite de intentos! &8(&c3&7/&c3&8)";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return plugin.NAME + "&eSie haben die Anzahl der Versuche überschritten! &8(&c3&7/&c3&8)";
        } else {
            return plugin.NAME + "&eToo many attempts! &8(&c3&7/&c3&8)";
        }
    }

    /**
     * Returns a String message indicating that the maximum number of attempts to modify the pin has been exceeded.
     *
     * @param plugin the main plugin instance
     * @return a string representing the exceeded modification attempts message
     */

    public static String exceededLimitModify(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return plugin.NAME + "&eToo many attempts! &8(&c1&7/&c1&8)";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return plugin.NAME + "&eHas superado el límite de intentos! &8(&c1&7/&c1&8)";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return plugin.NAME + "&eSie haben die Anzahl der Versuche überschritten! &8(&c1&7/&c1&8)";
        } else {
            return plugin.NAME + "&eToo many attempts! &8(&c1&7/&c1&8)";
        }
    }

    /**
     * Returns a String message indicating that the user has successfully logged in.
     *
     * @param plugin the main plugin instance
     * @return a string representing the successful login message
     */

    public static String userLogged(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return plugin.NAME + "&aYou're logged in!";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return plugin.NAME + "&a¡Has iniciado sesión!";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return plugin.NAME + "&aSie sind eingeloggt!";
        } else {
            return plugin.NAME + "&aYou're logged in!";
        }
    }

    /**
     * Returns a String message indicating that the user's pin has been successfully registered.
     *
     * @param plugin the main plugin instance
     * @return a string representing the successful pin registration message
     */

    public static String pinRegistered(Main plugin, String passString) {
        return plugin.NAME + " " + playerPass(passString, plugin).toLegacyText();
    }

    /**
     * Returns a String message indicating that the user's current pin is correct and they can choose a new pin.
     *
     * @param plugin the main plugin instance
     * @return a string representing the correct pin message
     */

    public static String modifyCorrectPin(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return plugin.NAME + "&aCorrect PIN! &7Choose your new PIN.";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return plugin.NAME + "&a¡PIN correcto! &7Elige tu nuevo PIN.";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return plugin.NAME + "Richtige PIN! &7Wählen Sie Ihre neue PIN.";
        } else {
            return plugin.NAME + "&aCorrect PIN! &7Choose your new PIN.";
        }
    }



    public static TextComponent playerPass(String passString, Main plugin) {
        TextComponent passwd = new TextComponent();
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            passwd.setText(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes(
                    '&', "&8[&f&lLock&6&lCraft&8] &ePIN successfully registered! &7Mouse over to view it."));
            passwd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(passString).
                    color(net.md_5.bungee.api.ChatColor.GREEN).create()));
            return passwd;

        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            passwd.setText(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes(
                    '&', "&8[&f&lLock&6&lCraft&8] &e¡El PIN ha sido registrado! &7Pasa el ratón por encima."));
            passwd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(passString).
                    color(net.md_5.bungee.api.ChatColor.GREEN).create()));
            return passwd;

        } else if (config.getString(language).equalsIgnoreCase("german")) {
            passwd.setText(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes(
                    '&', "&8[&f&lLock&6&lCraft&8] &ePIN erfolgreich registriert! &7Maus hierher."));
            passwd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(passString).
                    color(net.md_5.bungee.api.ChatColor.GREEN).create()));
            return passwd;
        } else {
            passwd.setText(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes(
                    '&', "&8[&f&lLock&6&lCraft&8] &ePIN successfully registered! &7Mouse over to view it."));
            passwd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(passString).
                    color(net.md_5.bungee.api.ChatColor.GREEN).create()));
            return passwd;
        }
    }
    
    public static String registerTxt(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return "&c&lRegister: &8Choose your PIN!";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return "&c&lRegister: &8¡Elige tu PIN!";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return "&c&lRegister: &8Wählen Sie Ihre PIN!";
        } else {
            return "&c&lRegister: &8Choose your PIN!";
        }
    }

    public static String loginTxt(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return "&c&lLogin: &8Type your PIN!";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return "&c&lLogin: &8¡Escribe tu pin!";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return "&c&lLogin: &8Geben Sie Ihre PIN ein!";
        } else {
            return "&c&lLogin: &8Type your PIN!";
        }
    }

    public static String modifyTxt(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return "&c&lModify: &8Choose your new PIN!";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return "&c&lModify: &8Elige tu nuevo PIN!";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return "&c&lModify: &8Ihre neue PIN!";
        } else {
            return "&c&lModify: &8Choose your new PIN!";
        }
    }

    public static String textYourActPin(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return "&aText your actually PIN.";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return "&aEscribe tu PIN actual.";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return "&aSchreiben Sie Ihre aktuelle PIN.";
        } else {
            return "&aText your actually PIN.";
        }
    }

    public static String wrongPin(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return "&cWrong PIN! ";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return "&cPIN incorrecto! ";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return "&cFalsche PIN! ";
        } else {
            return "&cWrong PIN! ";
        }
    }

    public static String chooseYourNewPin(Main plugin) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return "&aChoose your new PIN.";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return "&aElige tu nuevo PIN.";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return "&aWählen Sie Ihre neue PIN.";
        } else {
            return "&aChoose your new PIN.";
        }
    }

    public static String resetPin(Main plugin) {

        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            return "&9Reset PIN";
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            return "&9Resetear PIN";
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            return "&9PIN zurücksetzen";
        } else {
            return "&aChoose your new PIN.";
        }
    }
}
