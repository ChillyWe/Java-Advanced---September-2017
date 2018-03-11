package intro_to_java.Problem08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Chilly on 21.09.2017 г..
 */
public class GetNEvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] inputToken = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(inputToken[1]);
        boolean isOdd = isOdd(inputToken[2].toLowerCase());
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(isOdd && Math.abs(numbers[i]) % 2 == 1) {
                System.out.printf("%d ", numbers[i]);
                count++;
            }
            if(!isOdd && numbers[i] % 2 == 0) {
                System.out.printf("%d ", numbers[i]);
                count++;
            }
            if (count == n) {
                break;
            }
        }
    }

    private static boolean isOdd(String s) {
        if (s.equals("odd")) {
            return true;
        }
        else {
            return false;
        }
    }
}