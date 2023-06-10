package messages;

import functionality.Main;

public class PinMessages {

    public static String exceededLimit(Main plugin) {
        return plugin.NAME + "&eToo many attempts! &8(&c3&7/&c3&8)";
    }

    public static String userLogged(Main plugin) {
        return plugin.NAME + "&aYou're logged in!";
    }

    public static String pinRegistered(Main plugin) {
        return plugin.NAME + "&aYour pin has been successfully registered! &7Your pin is: &a";
    }

    public static String modifyCorrectPin(Main plugin) {
        return plugin.NAME + "&aCorrect PIN! &7Choose your new PIN.";
    }

    public static String pinChanged(Main plugin) {
        return plugin.NAME + "&aPIN successfully changed! &7Your new PIN is: &f";
    }
}
