package functionality;

import org.bukkit.entity.Player;

public class RegisterPassword {

    private Player player;
    private String pass;
    private int attempts;
    private int maxAttempts;

    /**
     * Constructs a new RegisterPassword instance for a player.
     * The instance represents a process of registering a password with a maximum number of attempts.
     *
     * @param player The Player object representing the player who is registering a password.
     * @param maxAttempts The maximum number of attempts allowed for password registration.
     */

    public RegisterPassword(Player player, int maxAttempts) {
        this.player = player;
        this.pass = "";
        this.maxAttempts = maxAttempts;
        this.attempts = this.maxAttempts;
    }


    /**
     * Returns the player associated with the RegisterPassword instance.
     *
     * @return Player associated with this instance.
     */

    public Player getPlayer() {
        return this.player;
    }

    /**
     * Adds a digit to the player's password.
     *
     * @param num The number to add to the password.
     */

    public void addPassNum(int num) {
        pass += num;
    }

    /**
     * Resets the player's password to an empty string.
     */

    public void resetPass() {
        pass = "";
    }

    /**
     * Returns the player's password.
     *
     * @return The player's password as a string.
     */

    public String getPass() {
        return this.pass;
    }

    /**
     * Returns the number of attempts left for the player to enter the password.
     *
     * @return The number of attempts left.
     */

    public int getAttempts() {
        return this.attempts;
    }

    /**
     * Returns the maximum number of attempts the player has to enter the password.
     *
     * @return The maximum number of attempts.
     */

    public int getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * Reduces the number of attempts left for the player by one.
     */

    public void reduceAttempts() {
        this.attempts--;
    }

}
