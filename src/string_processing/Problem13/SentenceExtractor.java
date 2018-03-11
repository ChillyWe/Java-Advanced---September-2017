package string_processing.Problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 30.09.2017 г..
 */
public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String key = reader.readLine();
        StringBuilder text = new StringBuilder(reader.readLine());
        List<StringBuilder> sentences = new ArrayList<>();
        int indexOf = 1;
        while(indexOf != 0) {
            indexOf = getIndexOf(text) + 1;
            String currText = text.substring(0, indexOf);
            if (currText.contains(" " + key + " ")) {
                sentences.add(new StringBuilder(currText));
            }
            text.replace(0, indexOf + 1, "");
        }
        for (StringBuilder sentence:sentences) {
            System.out.println(sentence.toString());
        }
    }

    private static int getIndexOf(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            char currChar = sb.charAt(i);
            if(currChar == '.') {
                return sb.indexOf(".");
            }
            else if (currChar == '!') {
                return sb.indexOf("!");
            }
            else if (currChar == '?') {
                return sb.indexOf("?");
            }
        }
        return - 1;
    }
}