package exam_preparations.re_take.p01_DHARMA_SolarFence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Chilly on 03.01.2018 г..
 */

// TODO DO NOT WORK LOOK SECOND TRY
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input = reader.readLine();
        while (!"Reprogram".equals(input)) {
            BigInteger number = new BigInteger(input);
            StringBuilder builder = new StringBuilder(number.toString(2));

           if (builder.length() < 33) {
               for (int i = builder.length(); i < 33; i++) {
                   builder.insert(0, "0");
               }
           }
            char[] array = builder.toString().toCharArray();

            for (int i = 0; i <= 30; i += 2) {
                int currBit = array[i];
                int prevBit = array[i + 1];
                if (prevBit == currBit) {
                    if (currBit == '1') {
                        array[i] = '0';
                        array[i + 1] = '0';
                    } else {
                        array[i] = '1';
                        array[i + 1] = '1';
                    }
                }
            }
            StringBuilder resBuilder = new StringBuilder();
            for (char c : array) {
                resBuilder.append(c);
            }
            BigInteger result = new BigInteger(resBuilder.toString(), 2);
            System.out.println(result.toString());
            input = reader.readLine();
        }
    }
}