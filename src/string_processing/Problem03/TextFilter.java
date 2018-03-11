package string_processing.Problem03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 26.09.2017 г..
 */
public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            String currBannedWord = bannedWords[i];

            Pattern pattern = 	Pattern.compile(currBannedWord);
            Matcher matcher = pattern.matcher(text);
            String encryptWord = newWord(currBannedWord.length());

            while (matcher.find())
                text = text.replace(currBannedWord, encryptWord);
        }
        System.out.println(text);
    }

    private static String newWord(int length) {
        String newStr = "";
        for (int i = 0; i < length; i++) {
            newStr += "*";
        }
        return newStr;
    }
}
