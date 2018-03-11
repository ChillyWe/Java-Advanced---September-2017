package intro_to_java.Problem10;

import java.util.Scanner;

public class XBits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] binaries = new String[8];

        for (int index = 0; index < binaries.length; index++) {
            String line = String.format("%32s", Integer.toBinaryString(
                    Integer.parseInt(scanner.nextLine()))).replace(' ', '0');
            binaries[index] = line;
        }

        char[][] table = new char[8][32];

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                table[row][col] = binaries[row].charAt(col);
            }
        }

        int[][] binaryTable = new int[8][32];

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                binaryTable[row][col] = Character.getNumericValue(table[row][col]);
            }
        }

        int count = 0;

        for (int row = 0; row < binaryTable.length - 2; row++) {
            for (int col = 0; col < binaryTable[row].length - 2; col++) {

                if (    binaryTable[row][col] == 1 && binaryTable[row][col + 1] == 0 && binaryTable[row][col + 2] == 1 &&
                        binaryTable[row + 1][col] == 0 && binaryTable[row + 1][col + 1] == 1 && binaryTable[row + 1][col + 2] == 0 &&
                        binaryTable[row + 2][col] == 1 && binaryTable[row + 2][col + 1] == 0 && binaryTable[row + 2][col + 2] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}