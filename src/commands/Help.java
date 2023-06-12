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
import org.bukkit.entity.Player;

import java.awt.*;

public class Help implements CommandExecutor {

    private Main plugin;
    private Player player;
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

                player.playSound(player.getLocation(), Sound.ANVIL_USE, 10, 2);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&m-------------&8[&f&lLock&6&lCraft&8]&f&m-------------"));
                player.spigot().sendMessage(modifyPin);
                player.spigot().sendMessage(lcVersion);
                player.spigot().sendMessage(lcReload);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&m-------------------------------------"));

                return true;
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('8', CommandMessages.commandNotExitsMessage(plugin)));
                return false;
            }
        }
    }

    public void modifyPinTxt(TextComponent msg) {

        msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/modifypin"));
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                "Change your old PIN to a new one.").color(ChatColor.AQUA).create()));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/modifypin"));
    }

    public void versionTxt(TextComponent msg) {

        msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-version"));
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                "Check the plugin version.").color(ChatColor.AQUA).create()));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-version"));
    }

    public void reloadTxt(TextComponent msg) {

        msg.setText(ChatColor.translateAlternateColorCodes('&', "&7- &e/lc-reload"));
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                "Reload the plugin.").color(ChatColor.AQUA).create()));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lc-reload"));
    }

}
