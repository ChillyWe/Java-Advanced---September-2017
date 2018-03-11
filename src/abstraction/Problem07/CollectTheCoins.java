package abstraction.Problem07;

import java.util.Scanner;

/**
 * Created by Chilly on 27.09.2017 г..
 */
public class CollectTheCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lines = readLines(scanner);

        int length = maxNum(lines);

        char[][] table = fillTheTable(length, lines);

        String commandLine = scanner.nextLine();
        int coinCount = 0;
        int wallHits = 0;
        int currRow = 0;
        int currCol = 0;

        for (int i = 0; i < commandLine.length() - 1; i++) {
            switch (commandLine.charAt(i)) {
                case '>':
                    currCol += 1;
                    break;
                case '<':
                    currCol -= 1;
                    break;
                case '^':
                    currRow -= 1;
                    break;
                case 'V':
                    currRow += 1;
                    break;
                default:
                    break;
            }
            char currSymbol;
            try {
                currSymbol = table[currRow][currCol];
                if (currSymbol == '$') {
                    coinCount++;
                }
                else if (currSymbol == 0) {
                    wallHits++;
                }
                }
            catch (Exception e) {
                if (currRow >= table.length - 1) {
                    currRow--;
                }
                else if (currRow < 0) {
                    currRow++;
                    wallHits++;
                }
                if (currCol >= table[currRow].length) {
                    currCol--;
                }
                else if (currCol < 0) {
                    currCol++;
                }
            }

        }
        System.out.println("Coins = " + coinCount);
        System.out.println("Walls = " + wallHits);
    }

    private static char[][] fillTheTable(int length, String[] lines) {
        char[][] table = new char[4][length];

        for (int row = 0; row < 4; row++) {
            char[] currLine = lines[row].toCharArray();
            for (int col = 0; col < length; col++) {
                if (col < currLine.length) {
                    table[row][col] = currLine[col];
                }
                else {
                    break;
                }
            }
        }
        return table;
    }

    private static String[] readLines(Scanner scanner) {
        String[] lines = new String[4];
        for (int i = 0; i < 4; i++) {
            String currLine = scanner.nextLine();
            lines[i] = currLine;
        }
        return lines;
    }

    private static int maxNum (String[] lines) {
        int largest = 0;
        for (int i = 0; i < 4; i++) {
            if(lines[i].length() > largest) {
                largest = lines[i].length();
            }
        }
        return largest;
    }
}