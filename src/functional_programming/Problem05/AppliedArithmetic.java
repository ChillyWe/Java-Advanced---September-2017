package functional_programming.Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Chilly on 06.10.2017 г..
 */
public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                                .mapToInt(Integer::parseInt).toArray();

        String command = reader.readLine();
        while (!command.equals("end")) {
            numbers = menu(command, numbers);
            command = reader.readLine();
        }
    }

    private static int[] menu(String command, int[] list) {
        switch (command) {
            case "add":
                list = Arrays.stream(list).map(a -> a + 1).toArray();
                break;
            case "multiply":
                list = Arrays.stream(list).map(a -> a * 2).toArray();
                break;
            case "subtract":
                list = Arrays.stream(list).map(a -> a - 1).toArray();
                break;
            case "print":
                System.out.println(Arrays.toString(list).replace("]", "").replace("[", "")
                                                        .replace(",", ""));
                break;
        }
        return list;
    }
}