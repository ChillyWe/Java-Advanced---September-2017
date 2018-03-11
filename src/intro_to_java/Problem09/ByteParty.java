package intro_to_java.Problem09;

import java.util.Scanner;

/**
 * Created by Chilly on 19.09.2017 г..
 */
public class ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        int[] data = new int[n];
        int dataLength = data.length;

        for (int i = 0; i < n; i++) {
            int currentInt = Integer.parseInt(scanner.nextLine());
            data[i] = currentInt;
        }

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input[0].equals("party")) {
                for (int num:data) {
                    System.out.println(num);
                }
                break;
            }
            int action = Integer.parseInt(input[0]);
            int position = Integer.parseInt(input[1]);
            int mask = 0;
            switch (action) {
                case -1:
                     mask = 1 << position;
                    for (int i = 0; i < dataLength; i++) {
                        data[i] = (data[i] ^ mask);
                    }
                    break;
                case 0:
                    mask = ~(1 << position);
                    for (int i = 0; i < dataLength; i++) {
                        data[i] = (data[i] & mask);
                    }
                    break;
                case 1:
                    mask = 1 << position;
                    for (int i = 0; i < dataLength; i++) {
                        data[i] = (data[i] | mask);
                    }
                    break;
                    default:
                        break;
            }
        }
    }
}