package object_classes_and_APIS.Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Created by Chilly on 07.10.2017 г..
 */
public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Character> bottomStack = new ArrayDeque<>();
        ArrayDeque<Character> topQueue = new ArrayDeque<>();

        String input = reader.readLine();

        for (int i = 0; i < input.length() / 2; i++) {
            char ch = input.charAt(i);
            char tCh = input.charAt(i + (input.length() / 2));
            bottomStack.push(ch);
            topQueue.addLast(tCh);
        }
        if (input.length() % 2 != 0) {
            System.out.println("NO");
        }
        else {
            checkBalance(bottomStack, topQueue, input.length() / 2);
        }

    }

    private static void checkBalance (ArrayDeque<Character> bottom, ArrayDeque<Character> top, int n) {
        for (int i = 0; i < n; i++) {
            char bott = bottom.peek();
            char topc = top.peek();
            boolean balance = check(bott, topc);
            if (!balance) {
                System.out.println("NO");
                break;
            }
            else if (i == n - 1 && balance) {
                System.out.println("YES");
            }
        }
    }

    private static boolean check(char c1, char c2) {
        boolean checkTrue = false;
        switch (c1) {
            case '(':
                if(c2 == ')') {
                   checkTrue = true;
                }
                break;
            case '{':
                if (c2 == '}') {
                    checkTrue = true;
                }
                break;
            case '[':
                if (c2 == ']') {
                    checkTrue = true;
                }
                break;
        }
        return checkTrue;
    }
}