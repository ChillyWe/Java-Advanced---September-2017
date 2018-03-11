package object_classes_and_APIS.Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Chilly on 03.10.2017 г..
 */
public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] commands = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = commands[0];
        int s = commands[1];
        int x = commands[2];

        int[] elements = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            queue.add(elements[i]);
        }
        for (int i = 0; i < s; i++) {
            queue.remove();
        }
        boolean exists = queue.contains(x);
        if (exists) {
            System.out.println("true");
        }
        else {
            try {
                System.out.println(Collections.min(queue));
            }
            catch (Exception e) {
                System.out.println("0");
            }
        }
    }
}