package exam_preparations.examII.Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 19.10.2017 г..
 */
public class LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> queue = new ArrayDeque<>();

        String line = reader.readLine();

        Pattern pattern = Pattern.compile("(?<number>[+-]?([0-9]*[.])?[0-9]+)+(?<length>[a-zA-Z]+)?");

        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String number = matcher.group("number");
            int length = -1;
            try {
                length = matcher.group("length").length();
            }
            catch (Exception e) {}
            queue.addLast(number);
            if (length != -1 && length % 2 == 0) {
                queue.addLast("+");
            }
            else if(length != -1) {
                queue.addLast("-");
            }
        }
        BigDecimal totalResult = new BigDecimal(Double.parseDouble(queue.poll()));
        while (queue.size() > 1) {
            totalResult = getResult(totalResult, queue.poll(), new BigDecimal(queue.poll()));
        }
        MathContext mc = new MathContext(0);
        totalResult = totalResult.round(mc);
        System.out.println(totalResult);
    }

    private static BigDecimal getResult(BigDecimal number, String operation, BigDecimal nextNumber) {
        if (operation.equals("+")) {
            return number.add(nextNumber);
        }
        return number.subtract(nextNumber);
    }
}