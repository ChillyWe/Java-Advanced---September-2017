package object_classes_and_APIS.Problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Chilly on 03.10.2017 г..
 */
public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> phonebook = new HashMap<>();

        String inputLine = reader.readLine();
        while (!inputLine.equals("search")) {
            String[] inputTokens = inputLine.split("-");
            String name = inputTokens[0];
            String phoneNumber = inputTokens[1];
            if(phonebook.containsKey(name)) {
                phonebook.replace(name, phoneNumber);
            }
            else {
                phonebook.put(name, phoneNumber);
            }
            inputLine = reader.readLine();
        }
        inputLine = reader.readLine();
        while (!inputLine.equals("stop")) {
            String currSearchedName = inputLine;
            if (phonebook.containsKey(currSearchedName)) {
                System.out.println(currSearchedName + " -> " + phonebook.get(currSearchedName));
            }
            else {
                System.out.println("Contact " + currSearchedName + " does not exist.");
            }
            inputLine = reader.readLine();
        }
    }
}