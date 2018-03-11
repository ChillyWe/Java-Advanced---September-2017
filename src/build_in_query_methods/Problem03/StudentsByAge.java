package build_in_query_methods.Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

/**
 * Created by Chilly on 10.10.2017 г..
 */
public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> data = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!line.equals("END")) {
            String[] inputTokens = line.split("\\s+");
            String name = inputTokens[0] + " " + inputTokens[1];
            int age = Integer.parseInt(inputTokens[2]);
            data.put(name, age);

            line = reader.readLine();
        }
        data.entrySet().stream().filter(age -> age.getValue() >= 18 && age.getValue() <= 24)
                        .forEach(s -> System.out.printf("%s %d%n", s.getKey(), s.getValue()));
    }
}