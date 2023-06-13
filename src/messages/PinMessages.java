package messages;

import functionality.Main;

public class PinMessages {

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

    public static String pinRegistered(Main plugin) {
        return plugin.NAME + "&aYour pin has been successfully registered! &7Your pin is: &a";
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

    /**
     * Returns a String message indicating that the user's pin has been successfully changed.
     *
     * @param plugin the main plugin instance
     * @return a string representing the successful pin change message
     */

    public static String pinChanged(Main plugin) {
        return plugin.NAME + "&aPIN successfully changed! &7Your new PIN is: &f";
    }
}
