package commands;

import functionality.Main;
import messages.CommandMessages;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {

    private Main plugin;
    private Player player;
    static String language = "Config.language";
    TextComponent modifyPin = new TextComponent();
    TextComponent lcVersion = new TextComponent();
    TextComponent lcReload = new TextComponent();

    public Help(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            CommandMessages.consoleCommandMessage(plugin);
            return false;
        } else {
            player = (Player) commandSender;
            if (command.getName().equalsIgnoreCase("lc-help")) {
                modifyPinTxt(modifyPin);
                versionTxt(lcVersion);
                reloadTxt(lcReload);

                if (player.isOp()) {
                    //Comand for op users
                    player.playSound(player.getLocation(), Sound.ANVIL_USE, 10, 2);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&m-------------&8[&f&lLock&6&lCraft&8]&f&m-------------"));
                    player.spigot().sendMessage(modifyPin);
                    player.spigot().sendMessage(lcVersion);
                    player.spigot().sendMessage(lcReload);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&m-------------------------------------"));
                } else {
                    //Comand for not op users
                    player.playSound(player.getLocation(), Sound.ANVIL_USE, 10, 2);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&m-------------&8[&f&lLock&6&lCraft&8]&f&m-------------"));
                    player.spigot().sendMessage(modifyPin);
                    player.spigot().sendMessage(lcVersion);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&m-------------------------------------"));
                }

                return true;
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('8', CommandMessages.commandNotExitsMessage(plugin)));
                return false;
            }
        }
    }

    /**
     * Modifies a TextComponent to display an interactive command usage message
     * about changing a user's PIN.
     * <p>
     * When the text is hovered over, it displays a tooltip that explains
     * what the command does.
     * <p>
     * When the text is clicked, it suggests the /modifypin command in the
     * command prompt.
     *
     * @param msg the TextComponent to modify
     */

    public void modifyPinTxt(TextComponent msg) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/modifypin"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Change your old PIN to a new one.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/modifypin"));
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/modifypin"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Cambia tu antiguo PIN por uno nuevo.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/modifypin"));
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/modifypin"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Ändern Sie Ihre alte PIN in eine neue.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/modifypin"));
        } else {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/modifypin"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Change your old PIN to a new one.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/modifypin"));
        }
    }


    /**
     * Modifies a TextComponent to display an interactive command usage message
     * about checking the plugin version.
     * <p>
     * When the text is hovered over, it displays a tooltip that explains
     * what the command does.
     * <p>
     * When the text is clicked, it suggests the /lc-version command in the
     * command prompt.
     *
     * @param msg the TextComponent to modify
     */

    public void versionTxt(TextComponent msg) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-version"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Check the plugin version.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-version"));
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-version"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Comprueba la versión del plugin.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-version"));
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-version"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Prüfen Sie die Plugin-Version.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-version"));
        } else {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-version"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Check the plugin version.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-version"));
        }
    }

    /**
     * Modifies a TextComponent to display an interactive command usage message
     * about reloading the plugin.
     * <p>
     * When the text is hovered over, it displays a tooltip that explains
     * what the command does.
     * <p>
     * When the text is clicked, it suggests the /lc-reload command in the
     * command prompt.
     *
     * @param msg the TextComponent to modify
     */

    public void reloadTxt(TextComponent msg) {
        FileConfiguration config = plugin.getConfig();

        if (config.getString(language).equalsIgnoreCase("english")) {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-reload"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Reload the plugin.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-reload"));
        } else if (config.getString(language).equalsIgnoreCase("spanish")) {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-reload"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Recarga el plugin.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-reload"));
        } else if (config.getString(language).equalsIgnoreCase("german")) {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-reload"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Laden Sie das Plugin neu.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-reload"));
        } else {
            msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-reload"));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    "Reload the plugin.").color(ChatColor.AQUA).create()));
            msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-reload"));
        }
    }

}
