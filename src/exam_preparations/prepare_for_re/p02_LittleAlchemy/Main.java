package exam_preparations.prepare_for_re.p02_LittleAlchemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Created by Chilly on 02.01.2018 г..
 */
public class Main {
    private static ArrayDeque<Integer> storage = new ArrayDeque<>();
    private static ArrayDeque<Integer> stones = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersAsStr = reader.readLine().split("\\s+");
        for (String number : numbersAsStr) {
            stones.addLast(Integer.parseInt(number));
        }

        String line;
        while (!"Revision".equalsIgnoreCase(line = reader.readLine())) {
            String[] commandTokens = line.split("\\s+");
            int specialNumber = Integer.parseInt(commandTokens[2]);
            switch (commandTokens[0]) {
                case "Apply":
                    ApplyMethod(specialNumber);
                    break;
                case "Air":
                    AirMethod(specialNumber);
                    break;
                default:
                    break;
            }
        }
        System.out.println(String.join(" ", stones.toString()).replaceAll("[\\,\\[\\]]", ""));
        System.out.println(storage.size());
    }

    private static void AirMethod(int specialNumber) {
        if (storage.peek() != null) {
            storage.poll();
            stones.addLast(specialNumber);
        }
    }

    private static void ApplyMethod(int specialNumber) {
        if (stones.peek() != null) {
            for (int i = 0; i < specialNumber; i++) {
                if (stones.peek() != null) {
                    int stone = stones.poll() - 1;
                    if (stone == 0) {
                        storage.addLast(stone);
                    } else {
                        stones.addLast(stone);
                    }
                }
            }
        }
    }
}