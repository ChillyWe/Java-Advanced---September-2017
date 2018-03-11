package data_representation_and_data_manipulation.Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 29.09.2017 г..
 */
public class NestedLoopsToRecursion {
    public static int[] loops;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        loops = new int[n];
        NestedLoops(0, n);
    }

    static void NestedLoops(int currentLoop, int n)
    {
        if (currentLoop == n)
        {
            PrintLoops(n);
            return;
        }
        for (int counter = 1; counter <= n; counter++)
        {
            loops[currentLoop] = counter;
            NestedLoops(currentLoop + 1, n);
        }
    }

    static void PrintLoops(int n)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            sb.append(loops[i] + " ");
        }
        System.out.println(sb.toString());
    }
}