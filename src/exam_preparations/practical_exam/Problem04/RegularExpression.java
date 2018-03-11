package exam_preparations.practical_exam.Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 22.10.2017 г..
 */
public class RegularExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        String currPattern = reader.readLine();
        while (!currPattern.equals("Print")) {
            if (currPattern.contains("#")) {
                
            }
            Pattern pattern = Pattern.compile(currPattern);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {

            }
        }
    }
}