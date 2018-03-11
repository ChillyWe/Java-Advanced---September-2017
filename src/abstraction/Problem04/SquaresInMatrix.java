package abstraction.Problem04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Chilly on 24.09.2017 г..
 */
public class SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] inputTokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = inputTokens[0];
        int cols = inputTokens[1];

        String[][] matrix = fillTheMatrix(scanner, rows, cols);

        int count = check(rows, cols, matrix);
        System.out.println(count);
    }

    private static int check(int rows, int cols, String[][] matrix) {
        int count = 0;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                String firstBox = matrix[row][col];
                String secondBox = matrix[row][col + 1];
                String thirdBox = matrix[row + 1][col];
                String fourthBox = matrix[row + 1][col + 1];
                if(firstBox.equals(secondBox) && secondBox.equals(thirdBox) && thirdBox.equals(fourthBox)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static String[][] fillTheMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currLine = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currLine[col];
            }
        }
        return matrix;
    }
}