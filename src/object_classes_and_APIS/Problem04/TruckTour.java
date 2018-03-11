package object_classes_and_APIS.Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Created by Chilly on 03.10.2017 г..
 */
public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        ArrayDeque<String[]> allPumps = new ArrayDeque<>();

        for (int i = 0; i < number; i++) {
            allPumps.addLast(reader.readLine().split(" "));
        }

        int counter = 0;
        while (true) {
            long fuel = 0;
            boolean found = true;
            for (String[] petrolPump : allPumps) {
                long petrol = Integer.parseInt(petrolPump[0]);
                long distance = Integer.parseInt(petrolPump[1]);
                fuel+=petrol;
                if (distance > fuel){
                    found = false;
                    break;
                }
                fuel-=distance;
            }
            if(found){
                System.out.println(counter);
                break;
            }
            String[] pump = allPumps.pop();
            allPumps.addLast(pump);
            counter++;
        }
    }
}