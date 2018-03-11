package exam_preparations.re_take.p04_TheSwamStation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chilly on 03.01.2018 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();

        ArrayDeque<Integer> theNumbers = new ArrayDeque<>();
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        seedTheNumbersAndIntegers(reader, theNumbers, integers);

        while (true) {
            if (result.size() == 6) {
                break;
            }

            int firstInteger = integers.poll();
            int theFirstNumber = theNumbers.peek();
            if (firstInteger % theFirstNumber == 0) {
                result.add(firstInteger);
                theNumbers.poll();
            } else {
                integers.addLast(++firstInteger);
            }
        }

        System.out.println(String.join(", ", result.toString()).replaceAll("[\\[\\]]", ""));
    }

    private static void seedTheNumbersAndIntegers(BufferedReader reader, ArrayDeque<Integer> theNumbers, ArrayDeque<Integer> integers) throws IOException {
        int[] theNumbersLine = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] integersLine = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i : theNumbersLine) {
            theNumbers.addLast(i);
        }

        for (int i : integersLine) {
            integers.addLast(i);
        }
    }
}