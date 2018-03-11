package string_processing.Problem09;

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
public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
        String name = reader.readLine();
        List<String> validNames = new ArrayList<>();

        while(!name.equals("end")) {
            Matcher matcher = pattern.matcher(name);

            boolean match = matcher.find();
            if (match) {
                validNames.add(name);
            }
            name = reader.readLine();
        }
        for (String currName:validNames) {
            System.out.println(currName);
        }
    }
}