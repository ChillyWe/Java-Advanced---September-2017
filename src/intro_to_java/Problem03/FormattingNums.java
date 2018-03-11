package intro_to_java.Problem03;

import java.util.Scanner;

/**
 * Created by Chilly on 19.09.2017 г..
 */
public class FormattingNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.next());
        double b = Double.parseDouble(scanner.next());
        double c = Double.parseDouble(scanner.next());

        String firstColumn = Integer.toHexString(a);
        firstColumn = fillColumn(firstColumn);

        String secondColumn = Integer.toBinaryString(a);
        fillWithZeros(secondColumn);
        if (secondColumn.length() < 10) {
            secondColumn = fillWithZeros(secondColumn);
        }

        String thirdColumn = thirdColumn(b);
        String fourtColumn = fourtColumn(c);

        System.out.printf("|%s|%s|%s|%s|", firstColumn, secondColumn, thirdColumn, fourtColumn);
    }

    private static String fourtColumn(double num) {
        String column = String.format("%.3f", num);
        int length = column.length();
        for (int i = 0; i < 10 - length; i++) {
            column += " ";
        }
        return column.replace(',', '.');
    }

    private static String thirdColumn(double num) {
        String column = String.format("%.2f", num);
        int length = column.length();
        for (int i = 0; i < 10 - length; i++) {
            column = " " + column;
        }
        return column.replace(',', '.');
    }

    private static String fillWithZeros(String secondColumn) {
        for (int i = secondColumn.length(); i < 10; i++) {
            secondColumn = "0" + secondColumn;
        }
        return secondColumn;
    }

    private static String fillColumn(String firstColumn) {
        firstColumn = firstColumn.toUpperCase();
        for (int i = firstColumn.length(); i < 10; i++) {
            firstColumn += " ";
        }
        return firstColumn;
    }
}