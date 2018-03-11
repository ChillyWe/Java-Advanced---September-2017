package string_processing.Problem15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 01.10.2017 г..
 */
public class ValidUserNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String username = reader.readLine();
        boolean hasMatch = false;
        List<String> matches = new ArrayList<String>();
        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");

        while (!username.equals("END")){

            Matcher matcher = pattern.matcher(username);

            if (matcher.find()){
                matches.add("valid");
                hasMatch = true;
            }
            else{
                matches.add("invalid");
            }

            username = reader.readLine();
        }
        if (hasMatch) {
            for (int i = 0; i < matches.size(); i++) {
                System.out.println(matches.get(i));
            }
        }
    }
}