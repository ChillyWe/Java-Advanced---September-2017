package data_representation_and_data_manipulation.Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Chilly on 29.09.2017 г..
 */
public class CombinationsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        BigInteger factN = new BigInteger(factorial(n) + "");
        BigInteger factNK = new BigInteger(factorial(n - k) + "");
        BigInteger factK = new BigInteger(factorial(k) + "");
        BigInteger result = factN.divide(factNK.multiply(factK));

        System.out.println(result);
    }

    static long factorial(int num) {
        if (num == 0)
        {
            return 1;
        }
        return num * factorial(num - 1);
    }
}