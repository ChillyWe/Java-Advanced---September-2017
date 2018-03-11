package abstraction.Problem02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Chilly on 24.09.2017 г..
 */
public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] inputTokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                                        .mapToInt(Integer::parseInt).toArray();

        int rows = inputTokens[0];
        int cols = inputTokens[1];

        String[][]palindromMatrix = fillPalindromMatrix(rows, cols);
        print(rows, cols, palindromMatrix);
    }

    private static void print(int rows, int cols, String[][] palindromMatrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(palindromMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] fillPalindromMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "" + (char)('a' + row) + (char)('a' + row + col) + (char)('a' + row);
            }
        }
        return matrix;
    }
}