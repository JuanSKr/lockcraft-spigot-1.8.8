package utilities;

public class GetNum {

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
