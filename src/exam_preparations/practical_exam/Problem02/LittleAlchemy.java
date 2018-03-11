package exam_preparations.practical_exam.Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Created by Chilly on 22.10.2017 г..
 */
public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> table = new ArrayDeque<>();             // queue
        ArrayDeque<Integer> goldStorage = new ArrayDeque<>();       // stack

        String[] stones = reader.readLine().split("\\s+");
        for (String stone : stones) {
            table.addLast(Integer.parseInt(stone));
        }

        String[] commandLine = reader.readLine().split("\\s+");
        while (!commandLine[0].equals("Revision") && commandLine.length == 3) {
            if (commandLine[0].equals("Apply")) {
                applyAcid(table, goldStorage, commandLine[2]);
            }
            else if (commandLine[0].equals("Air")) {
                airShit(table, goldStorage, commandLine);
            }
            commandLine = reader.readLine().split("\\s+");
        }

        for (Integer stone : table) {
            System.out.printf("%d ", stone);
        }
        System.out.println();
        System.out.println(goldStorage.size());
    }

    private static void airShit(ArrayDeque<Integer> table, ArrayDeque<Integer> goldStorage, String[] commandLine) {
        if (goldStorage.size() != 0) {
            int value = Integer.parseInt(commandLine[2]);
            int currStone = goldStorage.pop();
            currStone = value;
            table.addLast(currStone);
        }
    }

    private static void applyAcid(ArrayDeque<Integer> table, ArrayDeque<Integer> goldStorage, String s) {
        int acid = Integer.parseInt(s);
        while (acid > 0 && table.size() > 0) {
            int currStone = table.poll();
            currStone--;
            acid--;
            if (currStone == 0) {
                goldStorage.push(currStone);
            }
            else {
                table.addLast(currStone);
            }
        }
    }
}