package string_processing.Problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 30.09.2017 г..
 */
public class ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String input = reader.readLine();
        while (!input.equals("END")) {
            sb.append(input).append("\r\n");
            input = reader.readLine();
        }
        Pattern pattern = Pattern.compile("<a(.+?)>(.*?)<\\/a>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(sb);

        String replacement = "[URL$1]$2[/URL]";
        String result = matcher.replaceAll(replacement);
        System.out.println(result);
    }
}