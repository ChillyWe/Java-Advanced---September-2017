package string_processing.Problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 29.09.2017 г..
 */
public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("^\\+359 2 ([1-9]{3}) ([1-9]{4})$");
        Pattern pattern1 = Pattern.compile("^\\+359-2-([1-9]{3})-([1-9]{4})$");

        String number = reader.readLine();

        while(!number.equals("end")) {
            Matcher matcher = pattern.matcher(number);
            Matcher matcher1 = pattern1.matcher(number);

            boolean match = matcher.find();
            if (match) {
                numbers.add(number);
            }
            boolean match1 = matcher1.find();
            if (match1) {
                numbers.add(number);
            }
            number = reader.readLine();
        }

        for (String currName:numbers) {
            System.out.println(currName);
        }
    }
}