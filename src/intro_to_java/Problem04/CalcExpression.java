package intro_to_java.Problem04;

import java.util.Scanner;

/**
 * Created by Chilly on 20.09.2017 г..
 */
public class CalcExpression {
    public static void main(String[] args) {
        double f1, f2, diff;
        double f1b, f1e, f2b, f2e;
        double a, b, c;

        Scanner scanner = new Scanner(System.in);

        a = Double.parseDouble(scanner.next());
        b = Double.parseDouble(scanner.next());
        c = Double.parseDouble(scanner.next());

        f1b = ((a*a) + (b*b)) / ((a*a) - (b*b));
        f1e = (a+b+c) / (Math.sqrt(c));
        f1 = Math.pow(f1b, f1e);

        f2b = (a*a) + (b*b) - (c*c*c);
        f2e = (a-b);
        f2 = Math.pow(f2b, f2e);

        diff = Math.abs(((a+b+c)/3) - ((f1+ f2)/2));

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }
}