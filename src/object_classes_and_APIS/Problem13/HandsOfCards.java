package object_classes_and_APIS.Problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Chilly on 06.10.2017 г..
 */
public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, HashSet<String>> data = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("JOKER")) {
            fillData(data, input);
            input = reader.readLine();
        }
        for (String player : data.keySet()) {
            int score = 0;
            HashSet<String> cards = data.get(player);
            for (String card : cards) {
                int p = power(card.charAt(0));
                int t = 0;
                if (p == 10) {
                    t = type(card.charAt(2));
                } else {
                    t = type(card.charAt(1));
                }
                score += (p * t);
            }
            result.put(player, score);
        }
        for (String player : result.keySet()) {
            System.out.println(player + ": " + result.get(player));
        }
    }

    private static int type (char currCard) {
        int type = 1;
        switch (currCard) {
            case 'S': type = 4;
                break;
            case 'H': type = 3;
                break;
            case 'D': type = 2;
                break;
            case 'C': type = 1;
                break;
        }
        return type;
    }

    private static int power (char currCard) {
        int power = 0;
        switch (currCard) {
            case '1': power = 10;
                break;
            case '2': power = 2;
                break;
            case '3': power = 3;
                break;
            case '4': power = 4;
                 break;
            case '5': power = 5;
                break;
            case '6': power = 6;
                break;
            case '7': power = 7;
                break;
            case '8': power = 8;
                break;
            case '9': power = 9;
                break;
            case 'J': power = 11;
                break;
            case 'Q': power = 12;
                break;
            case 'K': power = 13;
                break;
            case 'A': power = 14;
                break;
        }
        return power;
    }

    private static void fillData(Map<String, HashSet<String>> data, String input) {
        String[] inputTokens = input.split(": ");
        String name = inputTokens[0];
        String[] cards = inputTokens[1].split(", ");
        HashSet<String> currCards = new HashSet<>();
        for (String card : cards) {
            currCards.add(card);
        }

        if (data.containsKey(name)) {
            data.get(name).addAll(currCards);
        }
        else {
            data.put(name, currCards);
        }
    }
}