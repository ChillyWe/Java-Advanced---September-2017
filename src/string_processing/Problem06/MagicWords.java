package string_processing.Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Chilly on 26.09.2017 г..
 */
public class MagicWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] words = input.split(" ");

        System.out.print(areExchangeable(words));
    }

    private static boolean areExchangeable(String[] words) {
        HashMap<Character, Character> lettersMap = new HashMap<>();

        for (int i = 0; i < words[0].length(); i++) {
            char firstWordLetter = words[0].charAt(i);
            char secondWordLetter = words[1].charAt(i);
            if (!lettersMap.containsKey(firstWordLetter)) {
                lettersMap.put(firstWordLetter, secondWordLetter);
            }
            else if (!lettersMap.get(firstWordLetter).equals(secondWordLetter)) {
                return false;
            }
        }
        return true;
    }
}