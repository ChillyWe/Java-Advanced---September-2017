package exam_preparations.examII.Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Chilly on 20.10.2017 г..
 */
public class BitRoller {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(reader.readLine());
        int freeze = Integer.parseInt(reader.readLine());
        int rolls = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder(number.toString(2));

        System.out.println();
    }
}