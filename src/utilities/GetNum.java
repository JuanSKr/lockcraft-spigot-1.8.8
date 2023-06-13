package utilities;

public class GetNum {

    /**
     * Returns a number corresponding to the given slot number.
     * This is specifically used to map between two slot numbering systems.
     * If the input slot number is not recognized, the method returns 0.
     *
     * @param slot the original slot number
     * @return the corresponding slot number in the second numbering system
     */

    public static int getNumberSlot(int slot) {
        switch (slot) {
            case 12:
                return 1;
            case 13:
                return 2;
            case 14:
                return 3;
            case 21:
                return 4;
            case 22:
                return 5;
            case 23:
                return 6;
            case 30:
                return 7;
            case 31:
                return 8;
            case 32:
                return 9;
            default:
                return 0;
        }
    }
}
