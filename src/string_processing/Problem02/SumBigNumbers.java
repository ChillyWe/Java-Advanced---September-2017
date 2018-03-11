package string_processing.Problem02;

        import java.math.BigInteger;
        import java.util.Scanner;

/**
 * Created by Chilly on 26.09.2017 г..
 */
public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        BigInteger secondNumber = new BigInteger(scanner.nextLine());
        BigInteger result = firstNumber.add(secondNumber);

        System.out.println(result);
    }
}