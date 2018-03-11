package intro_to_java.Problem11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Chilly on 21.09.2017 г..
 */
public class GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxScore = Integer.MIN_VALUE;
        int sumAscii = 0;
        String winner = "";

        for (int i = 0; i <n; i++) {
            String name = scanner.nextLine();
            int score = Integer.parseInt(scanner.nextLine());
            sumAscii += score;
            char[] splitName = name.toCharArray();
            for (char c : splitName) {
                if((int)c % 2 == 0) {
                    sumAscii += (int) c;
                }
                else {
                    sumAscii-=(int)c;
                }
            }
            if(sumAscii > maxScore){
                maxScore = sumAscii;
                winner = name;
            }
            sumAscii = 0;
        }
        System.out.printf("The winner is %s - %d points" ,winner , maxScore);
    }
}
