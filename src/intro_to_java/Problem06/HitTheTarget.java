package intro_to_java.Problem06;

import java.util.Scanner;

/**
 * Created by Chilly on 21.09.2017 г..
 */
public class HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();
        int i;
        int j = 1;

        for ( i = 1; i <= 20; i++) {

            for (j = 1; j <= 20; j++) {
                if (i + j == target) {
                    System.out.printf("%d + %d = %d%n", i, j, target);
                }
                else if(i - j == target) {
                    System.out.printf("%d - %d = %d%n", i, j, target);
                }
            }
        }
    }
}
