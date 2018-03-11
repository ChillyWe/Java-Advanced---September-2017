package object_classes_and_APIS.Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Created by Chilly on 08.10.2017 г..
 */
public class SimpleTextEditor {
    private static StringBuilder text = new StringBuilder();
    private static ArrayDeque<String> saveManipulation = new ArrayDeque<>();
    private static ArrayDeque<String> lastErased = new ArrayDeque<>();
    private static ArrayDeque<Integer> lastAdd = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputCommand = reader.readLine().split(" ");
            int command = Integer.parseInt(inputCommand[0]);
            String argument = "";
            if(inputCommand.length != 1) {
               argument  = inputCommand[1];
            }
            if (command == 1 || command == 2) {
                saveManipulation.push(inputCommand[0]);
            }
            menu(command, argument);
        }
    }

    private static void menu(int command, String argument) {
        switch (command) {
            case 1:
                text.append(argument);
                lastAdd.push(argument.length());
                break;
            case 2:
                String erasedPart = text.substring(text.length() - Integer.parseInt(argument), text.length());
                lastErased.push(erasedPart);
                text.delete(text.length() - Integer.parseInt(argument), text.length());
                break;
            case 3:
                System.out.println(text.charAt(Integer.parseInt(argument) - 1));
                break;
            case 4:
                undo();
                break;
        }
    }

    private static void undo() {
        int command = Integer.parseInt(saveManipulation.pop());
        if (command == 1) {
            int length = text.length() - lastAdd.pop();
            text.delete(length, text.length());
        }
        else if(command == 2) {
            String partToAdd = lastErased.pop();
            text.append(partToAdd);
        }
    }
}