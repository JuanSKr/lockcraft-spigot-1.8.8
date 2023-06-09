package functionality;

import org.bukkit.entity.Player;

public class RegisterPassword {

    private Player player;
    private String pass;
    private int attempts;
    private int maxAttempts;

    public RegisterPassword(Player player, int maxAttempts) {
        this.player = player;
        this.pass = "";
        this.maxAttempts = maxAttempts;
        this.attempts = this.maxAttempts;
    }


    public Player getPlayer() {
        return this.player;
    }

    public void addPassNum(int num) {
       pass += num;
    }

    public void resetPass() {
       pass = "";
    }

    public String getPass() {
       return this.pass;
    }

    public int getAttempts() {
       return this.attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public void reduceAttempts() {
       this.attempts--;
    }

}
