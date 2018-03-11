package exam_preparations.examI.Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Chilly on 20.10.2017 г..
 */
public class BitFlipper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(reader.readLine());
        StringBuilder builder = new StringBuilder(number.toString(2));

        if(builder.length() < 65) {
            for (int i = builder.length(); i < 64; i++) {
                builder.insert(0, "0");
            }
        }
        char[] array = builder.toString().toCharArray();

        for (int i = 1; i <= 61; i++) {
            int prevBit = array[i - 1];
            int currBit = array[i];
            int nextBit = array[i + 1];
            if (prevBit == currBit && currBit == nextBit) {
                if (currBit == '1') {
                    array[i - 1] = '0';
                    array[i] = '0';
                    array[i + 1] = '0';
                }
                else {
                    array[i - 1] = '1';
                    array[i] = '1';
                    array[i + 1] = '1';
                }
                i += 2;
            }
        }
        StringBuilder resBuilder = new StringBuilder();
        for (char c : array) {
            resBuilder.append(c);
        }
        BigInteger result = new BigInteger(resBuilder.toString(), 2);
        System.out.println(result.toString());
    }
}