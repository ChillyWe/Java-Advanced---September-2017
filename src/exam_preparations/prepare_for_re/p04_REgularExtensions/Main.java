package exam_preparations.prepare_for_re.p04_REgularExtensions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 02.01.2018 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String line = reader.readLine();

        while (true) {
            if ("Print".equalsIgnoreCase(line)) {
                break;
            }
            if (line.contains("%")) {
                line = line.replace("%", "[\\S]*");
            }
            line = line.replace(".", "\\.").replace("!", "\\!")
            .replace("?", "\\?");
            Pattern pattern = Pattern.compile(line);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String match = text.substring(matcher.start(), matcher.end());
                String result = new StringBuilder(match).reverse().toString();
                text = text.replace(match, result);
            }
            line = reader.readLine();
        }
        System.out.println(text);
    }
}