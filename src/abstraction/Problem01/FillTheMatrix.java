package abstraction.Problem01;

import java.util.Scanner;

/**
 * Created by Chilly on 22.09.2017 г..
 */
public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(inputTokens[0]);
        String methodType = inputTokens[1];

        int[][] matrix = new int[n][n];
        switch (methodType) {
            case "A":
                matrix = methodA(matrix);
                break;
            case "B":
                matrix = methodB(matrix);
                break;
        }
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] methodA(int[][] matrix) {
       int count = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = count;
                count++;
            }
        }
        return matrix;
    }

    private static int[][] methodB(int[][] matrix) {
        int count = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                if (col % 2 == 0) {
                    matrix[col][row] = count;
                    count++;
                }
                else {
                    matrix[col][matrix.length - 1 - row] = count;
                    count++;
                }
            }
        }
        return matrix;
    }
}