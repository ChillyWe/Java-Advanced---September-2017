package intro_to_java.Problem07;

import java.util.Scanner;

/**
 * Created by Chilly on 21.09.2017 г..
 */
public class CharMulty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fString = scanner.next();
        String sString = scanner.next();

        int fLength = fString.length();
        int sLength = sString.length();

        int fStrPosition = 0;
        int sStrPosition = 0;
        int sum = 0;
        while (fStrPosition < fString.length() && sStrPosition < sString.length()) {
            int curr = fString.charAt(fStrPosition) * sString.charAt(sStrPosition);
            sum += curr;

            fStrPosition++;
            sStrPosition++;
        }
        if (fLength > sLength) {
            int n = fLength - sLength;
            for (int i = 0; i < n; i++) {
                sum += fString.charAt(fStrPosition + i);
            }
        }
        else if (fLength < sLength) {
            int n = sLength - fLength;
            for (int i = 0; i < n; i++) {
                sum += sString.charAt(sStrPosition + i);
            }
        }
        System.out.println(sum);
    }
}