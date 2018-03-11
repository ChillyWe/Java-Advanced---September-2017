package exam_preparations.re_take.p02_DHARMA_supplies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 03.01.2018 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern foodUnvalidatedPattern = Pattern.compile("(\\[#[0-9]*)([a-zA-Z0-9 ]*)(#[0-9]*\\])");
        Pattern drinkUnvalidatedPattern = Pattern.compile("(\\[#[a-z]*)([a-zA-Z0-9 ]*)(#[a-z]*\\])");

        List<String> allcrates = new ArrayList<>();
        List<String> foods = new ArrayList<>();
        List<String> drinks = new ArrayList<>();
        long numberOfLine = 0;
        long amountOfFood = 0;
        long amountOfDrink = 0;

        String line = reader.readLine();
        while (!"Collect".equals(line)) {
            Matcher matcher = foodUnvalidatedPattern.matcher(line);
            Matcher matcher1 = drinkUnvalidatedPattern.matcher(line);
            while (matcher.find()) {
                String crate = line.substring(matcher.start(), matcher.end());
                allcrates.add(crate);
            }
            while (matcher1.find()) {
                String crate = line.substring(matcher1.start(), matcher1.end());
                allcrates.add(crate);
            }
            numberOfLine++;
            line = reader.readLine();
        }
        long n = allcrates.size() / numberOfLine;

        Pattern foodPattern = Pattern.compile("(?<firstT>\\[#[0-9]{" + n + "})([a-zA-Z0-9]*)(?<secondT>#[0-9]{" + n + "}\\])");
        Pattern drinkPattern = Pattern.compile("(?<firstT>\\[#[a-z]{" + n + "})([a-zA-Z0-9]*)(?<secondT>#[a-z]{" + n + "}\\])");
        for (String crate : allcrates) {
            Matcher foodMatcher = foodPattern.matcher(crate);
            Matcher drinkMatcher = drinkPattern.matcher(crate);

            if (foodMatcher.find()) {

                    foods.add(crate);
                    amountOfFood = getAmountOfFood(amountOfFood, n, crate);

            }

            if (drinkMatcher.find()) {

                    drinks.add(crate);
                    amountOfDrink = getAmountOfDrink(amountOfDrink, n, crate);

            }
        }

        if (foods.size() + drinks.size() == 0) {
            System.out.println("No supplies found!");
        } else {
            System.out.println(String.format("Number of supply crates: %d", foods.size() + drinks.size()));
            System.out.println(String.format("Amount of food collected: %d", amountOfFood));
            System.out.println(String.format("Amount of drinks collected: %d", amountOfDrink));
        }
    }

    private static long getAmountOfDrink(long amountOfDrink, long n, String crate) {
        long crateBodyPower = 0;
        long tagPower = 0;
        String body = crate.substring(2 + (int)n, crate.length() - (2 + (int)n));
        String tagLength = crate.substring(2, 2 + (int)n);

        for (char c : body.toCharArray()) {
            crateBodyPower += (long) c;
        }
        for (char c : tagLength.toCharArray()) {
            tagPower += (long) c;
        }
        amountOfDrink += crateBodyPower * tagPower;
        return amountOfDrink;
    }

    private static long getAmountOfFood(long amountOfFood, long n, String crate) {
        long crateBodyPower = 0;
        String body = crate.substring(2 + (int)n, crate.length() - (2 + (int)n));
        List<Character> bodyChars = new ArrayList<>();
        for (char c : body.toCharArray()) {
            if (!bodyChars.contains(c)) {
                bodyChars.add(c);
            }
        }
        for (Character bodyChar : bodyChars) {
            crateBodyPower += (long) bodyChar;
        }
        amountOfFood += crateBodyPower * n;
        return amountOfFood;
    }
}