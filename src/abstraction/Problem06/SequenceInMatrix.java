package abstraction.Problem06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Chilly on 24.09.2017 г..
 */
public class SequenceInMatrix {
    private static List<String> finalResult = new ArrayList<>();
    private static List<String> tempResult = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputTokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = inputTokens[0];
        int cols = inputTokens[1];

        String[][] matrix = fillTheMatrix(scanner, rows, cols);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                tryDiagonal(matrix, i, j);
                tryRow(matrix, i, j);
            }
        }
        System.out.println(finalResult.toString().replaceAll("[\\[\\]]",""));
}

    private static void tryDiagonal(String[][] matrix, int row, int col) {
        tempResult.clear();
        tempResult.add(matrix[row][col].toUpperCase());
        for (int k = row; k < Math.min(matrix.length - 1,matrix[row].length-1); k++) {
            if(matrix[k][k].equals(matrix[k+1][k+1])){
                tempResult.add(matrix[k][k]);
            } else {
                break;
            }
        }
        checkIsCurrentSequenceLongest();
    }

    private static void tryRow(String[][] matrix, int row, int col) {
        tempResult.clear();
        tempResult.add(matrix[row][col].toUpperCase());
        for (int i = row; i < matrix.length - 1; i++) {
            if(matrix[i][col].equals(matrix[i+1][col])) {
                tempResult.add(matrix[i][col].toUpperCase());
            } else {
                break;
            }
        }
        checkIsCurrentSequenceLongest();
    }

    private static void checkIsCurrentSequenceLongest() {
        if (tempResult.size() >= finalResult.size()) {
            finalResult.clear();
            for (String aTempResult : tempResult) {
                finalResult.add(aTempResult.toLowerCase());
            }
        }
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