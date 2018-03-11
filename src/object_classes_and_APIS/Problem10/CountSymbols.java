package object_classes_and_APIS.Problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created by Chilly on 03.10.2017 г..
 */
public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Character, Integer> data = new TreeMap<>();

        char[] inputLine = reader.readLine().toCharArray();
        for (int i = 0; i < inputLine.length; i++) {
            char currChar = inputLine[i];
            if(data.containsKey(currChar)) {
                data.replace(currChar, data.get(currChar) + 1);
            }
            else {
                data.put(currChar, 1);
            }
        }
        for (char ch:data.keySet()) {
            System.out.printf("%s: %d time/s%n", ch, data.get(ch));
        }
    }
}