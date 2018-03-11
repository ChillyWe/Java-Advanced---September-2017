package intro_to_java.Problem12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Chilly on 22.09.2017 г..
 */
public class VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> vehiclesData = new ArrayList<>();
        int vehiclesSold = 0;

        String[] data = scanner.nextLine().split("\\s+");
        for (String token:data) {
            vehiclesData.add(token);
        }

        String[] inputToken = scanner.nextLine().split("\\s+");
        while (!inputToken[0].equals("End")) {
            char carType = inputToken[0].charAt(0);
            carType = Character.toLowerCase(carType);
            int carSeats = Integer.parseInt(inputToken[2]);
            String carData = carType + inputToken[2];

            if (vehiclesData.contains(carData)) {
                int price = carType * carSeats;
                vehiclesData.remove(carData);
                System.out.printf("Yes, sold for %d$%n", price);
                vehiclesSold++;
            }
            else {
                System.out.println("No");
            }

            inputToken = scanner.nextLine().split("\\s+");
        }
        System.out.println("Vehicles left: " + String.join(", ", vehiclesData));
        System.out.println("Vehicles sold: " + vehiclesSold);
    }
}