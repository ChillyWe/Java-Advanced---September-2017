package data_representation_and_data_manipulation.Problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chilly on 05.10.2017 г..
 */
public class FindTheMissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.valueOf(reader.readLine());
        long[] numbers = Arrays.stream(reader.readLine().split(", "))
                                .mapToLong(Long::valueOf).toArray();

        List<Long> numsList = new ArrayList<>();
        for (Long num : numbers) {
            numsList.add(Long.valueOf(num));
        }
        Collections.sort(numsList);
        long missingNum = 0L;
        for (long i = 1; i < n; i++) {
            if (!numsList.contains(i)) {
                missingNum = i;
                System.out.println(missingNum);
                break;
            }
        }

    }
}