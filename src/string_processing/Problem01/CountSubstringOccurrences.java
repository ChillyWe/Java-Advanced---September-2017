package string_processing.Problem01;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 26.09.2017 г..
 */
public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputTokens = scanner.nextLine().toLowerCase();
        String strToRep = scanner.nextLine().toLowerCase();
        Pattern pattern = Pattern.compile(strToRep);

        Matcher matcher = pattern.matcher(inputTokens);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
}