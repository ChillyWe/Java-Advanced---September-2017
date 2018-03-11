package exam_preparations.re_take.p01_DHARMA_SolarFence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Chilly on 03.01.2018 г..
 */
public class SecondTry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger tree = new BigInteger("3");
        BigInteger zero = new BigInteger("0");

        String input = reader.readLine();
        while (!"Reprogram".equals(input)) {
            BigInteger number = new BigInteger(input);
            for (int i = 0; i <= 30; i++) {
                BigInteger twoDigits = number.shiftRight(30 - i).and(tree);
                if (twoDigits.equals(tree) || twoDigits.equals(zero)) {
                    number = number.xor(tree.shiftLeft(30 - i));
                    i++;
                }
            }
            System.out.println(number);
            input = reader.readLine();
        }
    }
}