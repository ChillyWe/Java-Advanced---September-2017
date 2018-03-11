package functional_programming.Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chilly on 06.10.2017 г..
 */
public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(reader.readLine().split("\\s+"))
                                    .mapToInt(Integer::parseInt).boxed()
                                    .collect(Collectors.toList());
        int n = Integer.parseInt(reader.readLine());

        Collections.reverse(list);
        list.removeIf(x -> x % n == 0);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}