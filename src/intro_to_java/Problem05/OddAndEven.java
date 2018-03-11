package intro_to_java.Problem05;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Chilly on 20.09.2017 г..
 */

public class OddAndEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int length = numbers.length;

        if (length % 2 != 0) {
            System.out.println("invalid length");
        }
        else {
            for (int i = 0; i < length; i += 2) {
                int fNumber = numbers[i];
                int sNumber = numbers[i + 1];

                if (fNumber % 2 == 0 && sNumber % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", fNumber, sNumber);
                } else if (fNumber % 2 == 1 && sNumber % 2 == 1) {
                    System.out.printf("%d, %d -> both are odd%n", fNumber, sNumber);
                } else {
                    System.out.printf("%d, %d -> different%n", fNumber, sNumber);
                }
            }
        }
    }
}