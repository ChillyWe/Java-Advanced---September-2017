package abstraction.Problem05;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Chilly on 24.09.2017 г..
 */
public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputTokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = inputTokens[0];
        int cols = inputTokens[1];

        int[][] matrix = fillTheMatrix(scanner, rows, cols);

        checkAndPrint(rows, cols, matrix);
    }

    private static void checkAndPrint(int rows, int cols, int[][] matrix) {
        int best = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
               int firstLine = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2];
               int secondLine = matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2];
               int thirdLine = matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
               int currSum = firstLine + secondLine + thirdLine;

               if (currSum > best) {
                   best = currSum;
                   startRow = row;
                   startCol = col;
               }
            }
        }

        System.out.println("Sum = " + best);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(matrix[startRow + row][startCol + col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillTheMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] currLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currLine[col];
            }
        }
        return matrix;
    }
}