package string_processing.Problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 29.09.2017 г..
 */
public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputTokens = reader.readLine().split("\\s+");
        BigDecimal sum = new BigDecimal("0");

        Pattern pattern = Pattern.compile("([a-zA-Z]+[0-9]+[A-z]+)");
        for (int i = 0; i < inputTokens.length; i++) {
            Matcher matcher = pattern.matcher(inputTokens[i]);
            boolean match = matcher.find();
            if (match) {
                char beforeLetter = inputTokens[i].charAt(0);
                String numberAsString = inputTokens[i].substring(1, inputTokens[i].length() - 1);
                char afterLetter = inputTokens[i].charAt(inputTokens[i].length() - 1);
                int number = Integer.parseInt(numberAsString);

                sum = firstLetterOperation(sum, beforeLetter, number);
                sum = lastLetterOperation(sum, afterLetter, number);
            }
        }
        System.out.printf("%.2f", sum);
    }

    private static BigDecimal lastLetterOperation(BigDecimal sum, char afterLetter, int number) {
        if(isUpperCase(afterLetter)) {
            int index = takeNumberOfLetter(afterLetter);
            sum = sum.subtract(new BigDecimal(index));
        }
        else {
            int index = takeNumberOfLetter(afterLetter);
            sum = sum.add(new BigDecimal(index));
        }
        return sum;
    }

    private static BigDecimal firstLetterOperation(BigDecimal sum, char beforeLetter, int number) {
        if(isUpperCase(beforeLetter)) {
            int index = takeNumberOfLetter(beforeLetter);
            double currSum = (double)number / (double)index;
            sum = sum.add(new BigDecimal(currSum));
        }
        else {
            int index = takeNumberOfLetter(beforeLetter);
            double currSum = (double)number * (double)index;
            sum = sum.add(new BigDecimal(currSum));
        }
        return sum;
    }

    private static int takeNumberOfLetter(char letter) {
        letter = Character.toLowerCase(letter);
        int index = 0;
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < alphabet.length(); i++) {
            if (letter == alphabet.charAt(i)) {
                index = alphabet.indexOf(alphabet.charAt(i)) + 1;
                break;
            }
        }
        return index;
    }

    private static boolean isUpperCase(char letter) {
        if(Character.isUpperCase(letter)) {
            return true;
        }
        return false;
    }
}