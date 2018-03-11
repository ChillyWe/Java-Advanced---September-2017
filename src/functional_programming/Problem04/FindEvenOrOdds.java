package functional_programming.Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by Chilly on 06.10.2017 г..
 */
public class FindEvenOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputTokens = Arrays.stream(reader.readLine().split("\\s+"))
                                    .mapToInt(Integer::parseInt).toArray();
        int start = inputTokens[0];
        int end = inputTokens[1];
        String evenOrOdd = reader.readLine();
        boolean isEvenComm = isEvenCommand(evenOrOdd);

        Predicate<Integer> isEven = number -> number % 2 == 0;
        for (int i = start; i <= end; i++) {
            if(isEvenComm && isEven.test(i)) {
                System.out.print(i + " ");
            }
            else if (!isEvenComm && !isEven.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isEvenCommand (String s) {
        if(s.equals("even")) {
            return true;
        }
        return false;
    }
}