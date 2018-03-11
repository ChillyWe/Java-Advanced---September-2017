package build_in_query_methods.Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Chilly on 10.10.2017 г..
 */
public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> students = new HashSet<>();
        while (true){

            String input = reader.readLine();
            if("END".equals(input)) {
                break;
            }
            students.add(input);
        }
        students.stream().sorted((a,b) -> {
            if (a.split(" ")[1].compareTo(b.split(" ")[1]) == 0){
                return b.split(" ")[0].compareTo(a.split(" ")[0]);
            }
            return a.split(" ")[1].compareTo(b.split(" ")[1]);
        }).forEach(System.out::println);
    }
}