package string_processing.Problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 30.09.2017 г..
 */
public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Pattern emailPattern = Pattern.compile("[A-Za-z]+[.-_]*[A-Za-z]+@[A-Za-z]+[-]*[.A-Za-z]+[A-Za-z]");

        Matcher matcher = emailPattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}