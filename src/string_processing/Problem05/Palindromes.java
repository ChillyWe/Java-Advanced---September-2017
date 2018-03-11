package string_processing.Problem05;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Chilly on 26.09.2017 г..
 */
public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("[ .,!?]");
        Set<String> palindromes = new TreeSet<>();

        for (String word:words) {
            StringBuilder reversed = new StringBuilder(word).reverse();
            if(word.contains(reversed.toString())) {
                palindromes.add(word);
            }
        }
        palindromes.removeAll(Collections.singleton(""));
        System.out.println("[" + String.join(", ", palindromes) + "]");
    }
}