package object_classes_and_APIS.Problem14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

/**
 * Created by Chilly on 07.10.2017 г..
 */
public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Long> countryOnly = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> countryData = new LinkedHashMap<>();

        String inputLine = reader.readLine();

        while(!inputLine.equals("report")) {
            String[] inputTokens = inputLine.split("\\|");
            String country = inputTokens[1];
            String city = inputTokens[0];
            long population = Long.valueOf(inputTokens[2]);
            if (!countryData.containsKey(country)) {
                countryData.put(country, new LinkedHashMap<>());
                countryData.get(country).put(city, population);
                countryOnly.put(country, population);
            }
            else {
                if (!countryData.get(country).containsKey(city)) {
                    countryData.get(country).put(city, population);
                    countryOnly.replace(country, countryOnly.get(country) + population);
                }
                else {
                    countryData.get(country).replace(city, countryData.get(country).get(city) + population);
                    countryOnly.replace(country, countryOnly.get(country) + population);
                }
            }
            inputLine = reader.readLine();
        }

        countryData.entrySet().stream()
                .sorted((c1,c2)-> countryOnly.get(c2.getKey()).compareTo(countryOnly.get(c1.getKey())))
                .forEach(country -> {System.out.println(String.format("%s (total population: %d)",
                                    country.getKey(), countryOnly.get(country.getKey())));
                                 country.getValue().entrySet()
                                 .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue()))
                                                    .forEach(city -> System.out.println(String.format("=>%s: %d",
                                                    city.getKey(),city.getValue())));
                });
    }
}