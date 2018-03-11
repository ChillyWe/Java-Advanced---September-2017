package string_processing.Problem04;

import java.util.Scanner;

/**
 * Created by Chilly on 26.09.2017 г..
 */
public class UnicodeChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        for (char chr:input) {
            String print = toUnicode(chr);
            System.out.printf("%s", print);
        }
        System.out.println();
    }

    private static String toUnicode(char ch) {
        return String.format("\\u%04x", (int) ch);
    }
}