package data_representation_and_data_manipulation.Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 29.09.2017 г..
 */
public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split("\\s+");
        System.out.println(String.join(" ", reverseArray(array)));
    }

    private static String[] reverseArray(String[] x){
        reverse(x, 0, x.length -1);
        return x;
    }

    private static void reverse(String[] x, int i, int j){
        if(i<j){//Swap
            String tmp = x[i];
            x[i] = x[j];
            x[j] = tmp;
            reverse(x, ++i, --j);//Recursive
        }
    }
}