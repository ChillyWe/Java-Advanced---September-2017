package abstraction.Problem08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Chilly on 28.09.2017 г..
 */
public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                                        .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimension[0];
        int cols = matrixDimension[1];

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currLine = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currLine[col];
            }
        }
        String[] inputTokens = scanner.nextLine().split("\\s+");
        while (!inputTokens[0].equals("END")) {
            if (inputTokens[0].equals("swap") && inputTokens.length == 5) {
                int[] coordinate = Arrays.stream(inputTokens).skip(1).mapToInt(Integer::parseInt).toArray();
                int r1 = coordinate[0];
                int c1 = coordinate[1];
                int r2 = coordinate[2];
                int c2 = coordinate[3];

                if (r1 < 0 || r1 > rows || r2 < 0 || r2 > rows || c1 < 0 || c1 > cols || c2 < 0 || c2 > cols) {
                    System.out.println("Invalid input!");
                } else {
                    String reminder = matrix[r1][c1];
                    matrix[r1][c1] = matrix[r2][c2];
                    matrix[r2][c2] = reminder;
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                }
            }
            else {
                System.out.println("Invalid input!");
            }
            inputTokens = scanner.nextLine().split("\\s+");
        }
    }
}