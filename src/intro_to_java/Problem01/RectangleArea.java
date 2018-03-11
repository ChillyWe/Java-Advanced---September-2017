package intro_to_java.Problem01;

        import java.util.Scanner;

public class RectangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.next());
        double b = Double.parseDouble(scanner.next());

        double area = a * b;
        System.out.printf("%.2f", area);
    }
}