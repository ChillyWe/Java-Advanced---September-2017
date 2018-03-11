package exam_preparations.practical_exam.Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Chilly on 22.10.2017 г..
 */
public class VLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Set<String>> userFollowers = new HashMap<>();
        Map<String,Set<String>> userFollow = new HashMap<>();

        String[] inputLine = reader.readLine().split("\\s+");
        while (!inputLine[0].equals("Statistics")) {
            String vLoggerName = inputLine[0];
            String command = inputLine[1];
            String follow = inputLine[2];

            menu(userFollowers, userFollow, command, vLoggerName, follow);

            inputLine = reader.readLine().split("\\s+");
        }
    //    Comparator<Map.Entry<String,Set<String>>> by = Comparator.comparing(Map.Entry::getValue.,   Comparator.reverseOrder());

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.\n", userFollowers.size());



    }

    private static void menu(Map<String,Set<String>> userFollowers, Map<String,Set<String>> userFollow, String command, String userName, String followed) {
        switch (command) {
            case "joined":
                if (!userFollowers.containsKey(userName)) {
                    userFollowers.put(userName, new HashSet<>());
                    userFollow.put(userName, new HashSet<>());
                }
                break;
            case "followed":
                if (userFollowers.containsKey(userName) && !userName.equals(followed)) {
                    userFollowers.get(followed).add(userName);
                    userFollow.get(userName).add(followed);
                }
                break;
        }
    }
}