package functional_programming.Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

/**
 * Created by Chilly on 06.10.2017 г..
 */
public class CustomMinFunc {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        List<Integer> data = new ArrayList<>();

        for (int i : input) {
            data.add(i);
        }
        Function<List<Integer>, Integer> getMinValue = x -> Collections.min(x);
        int min = getMinValue.apply(data);
        System.out.println(min);
    }
}