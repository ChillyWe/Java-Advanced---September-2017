package data_representation_and_data_manipulation.Problem08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Chilly on 05.10.2017 г..
 */
public class MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger firstNum = new BigInteger(reader.readLine());
        BigInteger secondNum = new BigInteger(reader.readLine());

        System.out.println(new BigInteger(firstNum.multiply(secondNum).toString()));
    }
}