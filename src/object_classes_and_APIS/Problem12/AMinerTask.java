package object_classes_and_APIS.Problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Chilly on 06.10.2017 г..
 */
public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Long> data = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("stop")) {
            String resource = input;
            long quantity = Long.valueOf(reader.readLine());
            if(!data.containsKey(resource)) {
                data.put(resource, quantity);
            }
            else {
                data.replace(resource, data.get(resource) + quantity);
            }
            input = reader.readLine();
        }
        for (String resource : data.keySet()) {
            System.out.println(resource + " -> " + data.get(resource));
        }
    }
}