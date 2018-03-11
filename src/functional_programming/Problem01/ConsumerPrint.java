package functional_programming.Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * Created by Chilly on 06.10.2017 г..
 */
public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputTokens = reader.readLine().split("\\s+");

        Consumer<String> print = message -> System.out.println(message);
        for (String str : inputTokens) {
            print.accept(str);
        }
    }
}