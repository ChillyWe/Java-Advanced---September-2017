package abstraction.Problem03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Chilly on 24.09.2017 г..
 */
public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = fillTheMatrix(scanner, n);

        int primaryD = 0;
        int secondaryD = 0;
        for (int i = 0; i < n; i++) {
            primaryD += matrix[i][i];
            secondaryD += matrix[(n - 1) - i][i];
        }
        System.out.println(Math.abs(primaryD - secondaryD));
    }

    private static int[][] fillTheMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int[] currLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < n; col++) {
                matrix[row][col] = currLine[col];
            }
        }
        return matrix;
    }
}