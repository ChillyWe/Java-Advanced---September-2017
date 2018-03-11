package functional_programming.Problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Chilly on 11.10.2017 г..
 */
public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");
        Arrays.asList(names);

        Arrays.stream(names).filter(x -> x.length() <= n)
                            .forEach(x -> System.out.println(x));

    }
}