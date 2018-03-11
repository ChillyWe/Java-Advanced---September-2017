package intro_to_java.Problem13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Chilly on 23.09.2017 г..
 */
public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scanner.nextLine());
        int[] matrixDimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                                        .mapToInt((Integer::parseInt)).toArray();

        int rows = matrixDimension[0];
        int cols = matrixDimension[1];

        long[][] matrix = fillTheMatrix(scanner, rows, cols);

        int[] targetCoordinate = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt((Integer::parseInt)).toArray();

        int rowToBlur = targetCoordinate[0];
        int colToBlur = targetCoordinate[1];

        int startRow = Math.max(0, rowToBlur - 1);
        int endRow = Math.min(rows - 1, rowToBlur + 1);

        int startCol = Math.max(0, colToBlur - 1);
        int endCol = Math.min(cols - 1, colToBlur + 1);

        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                matrix[row][col] += blurAmount;
            }
        }

        print(matrix);
    }

    private static void print(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static long[][] fillTheMatrix(Scanner scanner, int rows, int cols) {
        long[][] matrix = new long[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] currRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(currRow[col]);
            }
        }
        return matrix;
    }
}