package exam_preparations.examI.Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chilly on 20.10.2017 г..
 */
public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();

        fillQueue(reader, queue);
        List<Integer> builder = new ArrayList<>();


        while (!queue.isEmpty()) {
            List<Integer> currActivities = queue.pop();

            int currWavePower = currActivities.get(0);
            for (int i = 1; i < currActivities.size(); i++) {
                if(currWavePower < currActivities.get(i)) {
                    List<Integer> saveThis = currActivities.subList(i, currActivities.size());
                    queue.addLast(saveThis);
                    break;
                }
            }
            builder.add(currWavePower);
        }
        System.out.println(builder.size());
        System.out.println(Arrays.toString(builder.toArray()).replaceAll("[\\]\\[,]", ""));
    }

    private static void fillQueue(BufferedReader reader, ArrayDeque<List<Integer>> queue) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            List<Integer> currLine = new ArrayList<>();
            String[] line = reader.readLine().split(" ");

            for (String aLine : line) {
                currLine.add(Integer.valueOf(aLine));
            }
            queue.addLast(currLine);
        }
    }
}