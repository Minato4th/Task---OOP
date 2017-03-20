import java.util.Random;

/**
 * 3/20/2017
 */
public class Test {
    public static void main(String[] args) {
        String digitSTR = "-15";

        for (int i = 0; i < digitSTR.length(); i++) {
            if (!Character.isDigit(digitSTR.charAt(i))){
                System.out.println("Illegal number, please set again");
                break;
            }
        }
    }
}
