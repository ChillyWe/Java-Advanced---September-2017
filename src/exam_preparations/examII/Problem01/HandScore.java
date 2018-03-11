package exam_preparations.examII.Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 19.10.2017 г..
 */
public class HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> cardsData = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<power>[0-9JQKA])(?<suits>[SHDC])");
        int score = 0;

        String line = reader.readLine();
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String power = matcher.group("power");
            String suit = matcher.group("suits");
            StringBuilder currCard = new StringBuilder();
            currCard.append(power).append(suit);
            cardsData.add(currCard.toString());
        }
        int count = 1;
        int bonus = 0;
        boolean isTrue = false;
        for (int i = 0; i < cardsData.size(); i++) {
            String card = cardsData.get(i);
            int currPower = menu(card.charAt(0));
            char currSuit = card.charAt(1);
            char nextSuit = ' ';
            try {
                nextSuit = cardsData.get(i + 1).charAt(1);
            }
            catch (Exception e) {

            }
            if (currSuit == nextSuit) {
                bonus += currPower;
                count++;
                isTrue = true;
            }
            else {
                if (isTrue) {
                    score += (bonus + currPower) * count;
                    count = 1;
                    bonus = 0;
                }
                else {
                    score += currPower;
                }
                isTrue = false;
            }
        }
        System.out.println(score);
    }

    private static int menu (char string) {
        int power = 0;
        switch (string) {
            case '0': power = 10;
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
            case 'J': power = 12;
            break;
            case 'Q': power = 13;
            break;
            case 'K': power = 14;
            break;
            case 'A': power = 15;
        }
        return power;
    }
}