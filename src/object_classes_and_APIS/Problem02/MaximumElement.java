package object_classes_and_APIS.Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Chilly on 03.10.2017 г..
 */
public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] currCommandStr = reader.readLine().split("\\s+");
            int[] currCommand = new int[currCommandStr.length];
            for (int j = 0; j < currCommand.length; j++) {
                int currElement = Integer.parseInt(currCommandStr[j]);
                currCommand[j] = currElement;
            }

            stack = menu(currCommand, stack);
        }
    }

    private static ArrayDeque<Integer> menu(int[] command, ArrayDeque<Integer> stack) {
        switch (command[0]) {
            case 1:
                int element = command[1];
                stack.push(element);
                break;
            case 2:
                stack.pop();
                break;
            case 3:
                System.out.println(Collections.max(stack));
                break;
        }
        return stack;
    }
}