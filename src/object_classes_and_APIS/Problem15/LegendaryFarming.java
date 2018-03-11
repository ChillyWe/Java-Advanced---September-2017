package object_classes_and_APIS.Problem15;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 08.10.2017 г..
 */
public class LegendaryFarming {
    private static TreeMap<String, Long> legendaryMats = new TreeMap<>();
    private static TreeMap<String, Long> junk = new TreeMap<>();
    private static String legendaryItem = "sWoRd>>";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        legendaryMats.put("shards", 0L);
        legendaryMats.put("fragments", 0L);
        legendaryMats.put("motes", 0L);

        boolean isThereLegendaryItem = false;
        Pattern validate = Pattern.compile("(?<quantity>\\d+)+ (?<material>\\w+)+", Pattern.DOTALL);

        while (true) {
            String inputLine = scanner.nextLine();
            if("".equals(inputLine)){
                break;
            }
            Matcher enter = validate.matcher(inputLine);
            while (enter.find()) {
                long quantity = Long.valueOf(enter.group("quantity"));
                String material = enter.group("material").toLowerCase();
                boolean isThereSpecialMat = checkForSpecialMat(material, quantity);
                if (isThereSpecialMat) {
                    isThereLegendaryItem = checkForLegendaryItem();
                } else {
                    if (junk.containsKey(material)) {
                        junk.replace(material, junk.get(material) + quantity);
                    } else {
                        junk.put(material, quantity);
                    }
                }
                if (isThereLegendaryItem) {
                    break;
                }
            }
            if (isThereLegendaryItem) {
                break;
            }
        }
        print();
    }

    private static void print() {
        System.out.println(legendaryItem);
        legendaryMats.entrySet().stream()
                .sorted((q1,q2)-> legendaryMats.get(q2.getKey()).compareTo(legendaryMats.get(q1.getKey())))
                .forEach(material -> System.out.println(material.getKey() +
                        ": " + legendaryMats.get(material.getKey())));


        for (Map.Entry<String, Long> kvp : junk.entrySet()) {
            System.out.println(kvp.getKey() + ": " + kvp.getValue());
        }
    }

    private static boolean checkForLegendaryItem () {
        boolean isThereAnyLegendaryItem = false;
        if(legendaryMats.get("shards") >= 250) {
            legendaryItem = "Shadowmourne obtained!";
            legendaryMats.replace("shards", legendaryMats.get("shards") - 250);
            isThereAnyLegendaryItem = true;
        }
        else if (legendaryMats.get("fragments") >= 250) {
            legendaryItem = "Valanyr obtained!";
            legendaryMats.replace("fragments", legendaryMats.get("fragments") - 250);
            isThereAnyLegendaryItem = true;
        }
        else if (legendaryMats.get("motes") >= 250) {
            legendaryItem = "Dragonwrath obtained!";
            legendaryMats.replace("motes", legendaryMats.get("motes") - 250);
            isThereAnyLegendaryItem = true;
        }
        return isThereAnyLegendaryItem;
    }

    private static boolean checkForSpecialMat(String material, long quantity) {
        boolean isTrue = false;
        switch (material) {
            case "shards":
                legendaryMats.replace(material, legendaryMats.get(material) + quantity);
                isTrue = true;
                break;
            case "fragments":
                legendaryMats.replace(material, legendaryMats.get(material) + quantity);
                isTrue = true;
                break;
            case "motes":
                legendaryMats.replace(material, legendaryMats.get(material) + quantity);
                isTrue = true;
                break;
        }
        return isTrue;
    }
}