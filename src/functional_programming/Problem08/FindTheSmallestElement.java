package functional_programming.Problem08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Chilly on 11.10.2017 г..
 */
public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                            .mapToInt(Integer::parseInt).toArray();
        int min = findMinIdx(numbers);
        System.out.println(min);
    }

    public static int findMinIdx(int[] numbers) {
        OptionalInt minimun = IntStream.of(numbers).min();
        return   IntStream.of(numbers).boxed().collect(toList()).indexOf(minimun.getAsInt());
    }
}