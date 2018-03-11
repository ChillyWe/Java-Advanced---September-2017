package data_representation_and_data_manipulation.Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Chilly on 29.09.2017 г..
 */
public class ImplementBinarySearchUsingRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //    int[] numbersArray = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] numbersAsString = reader.readLine().split("\\s+");
        int[] numbersArray = new int[numbersAsString.length];
        for (int i = 0; i < numbersAsString.length; i++) {
            int currNumber = Integer.parseInt(numbersAsString[i]);
            numbersArray[i] = currNumber;
        }

        int numberLookFor = Integer.parseInt(reader.readLine());
        int index = binarySearch(numbersArray, numberLookFor);
        System.out.println(index);
    }

    public static int binarySearch(int[] a, int target) {
        return binarySearch(a, 0, a.length-1, target);
    }

    public static int binarySearch(int[] a, int start, int end, int target) {
        int middle = (start + end) / 2;
        if(end < start) {
            return -1;
        }
        if(target == a[middle]) {
            return middle;
        }
        else if(target < a[middle]) {
            return binarySearch(a, start, middle - 1, target);
        }
        else {
            return binarySearch(a, middle + 1, end, target);
        }
    }
}
