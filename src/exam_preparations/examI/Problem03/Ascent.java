package exam_preparations.examI.Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 20.10.2017 г..
 */
public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(?<operation>[,_])(?<letters>[a-zA-Z]+)(?<digit>[0-9])");
        Map<String, String> map = new LinkedHashMap<>();


        while (true) {
            String line = reader.readLine();
            line = decryptInput(map, line);
            if (line.equals("Ascend")){
                break;
            }
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String replaceThis = matcher.group();
                String operator = matcher.group("operation");
                String letters = matcher.group("letters");
                int digit = Integer.parseInt(matcher.group("digit"));
                StringBuilder replaceWithThis = decrypt(operator, letters, digit);

                line = line.replace(replaceThis, replaceWithThis.toString());

                matcher = pattern.matcher(line);
                map.put(replaceThis, replaceWithThis.toString());
            }
            System.out.println(line);
        }
    }

    private static String decryptInput (Map<String,String> map, String line) {
        for (Map.Entry<String, String> kvp : map.entrySet()) {
            if (line.contains(kvp.getKey())) {
                line = line.replaceAll(kvp.getKey(), kvp.getValue());
            }
        }
        return line;
    }

    private static StringBuilder decrypt(String operator, String letters, int digit) {
        StringBuilder builder = new StringBuilder();
        if(operator.equals("_")) {
            for (int i = 0; i < letters.length(); i++) {
                builder.append((char) (letters.charAt(i) - digit));
            }
        } else {
            for (int i = 0; i < letters.length(); i++) {
                builder.append((char) (letters.charAt(i) + digit));
            }
        }
        return builder;
    }
}