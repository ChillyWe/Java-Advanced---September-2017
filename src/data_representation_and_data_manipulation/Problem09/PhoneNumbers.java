package data_representation_and_data_manipulation.Problem09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder b = new StringBuilder();
        String line = reader.readLine();
        while (!line.equalsIgnoreCase("end")){
            b.append(line);
            line = reader.readLine();
        }
        String text = b.toString();
        Matcher matcher = extractNamesAndPhones(text);
        Map<String, String> phoneList = new LinkedHashMap<>();

        while(matcher.find()) {
            Matcher names = extractNames(matcher.group(0));
            Matcher phones = extractPhones(matcher.group(0));
            if(names.find() && phones.find()) {
                String name = names.group(0);
                String phone = phones.group(0).replaceAll("[^+0-9]", "");
                phoneList.put(name, phone);
            }
        }
        printPhoneList(phoneList);
    }

    private static Matcher extractNamesAndPhones(String text){
        Pattern regex = Pattern.compile("[A-Z][A-Za-z]*[^a-zA-Z+]*\\+?\\d[\\d\\s()./\\-]*\\d");
        return regex.matcher(text);
    }

    private static Matcher extractNames(String text){
        Pattern regex = Pattern.compile("[A-Z][a-zA-Z]*");
        return regex.matcher(text);
    }

    private static Matcher extractPhones(String text){
        Pattern regex = Pattern.compile("\\+*\\d[\\d\\s()./-]+\\d");
        return regex.matcher(text);
    }

    private static void printPhoneList(Map<String, String> list){
        if(list.isEmpty()){
            System.out.println("<p>No matches!</p>");
            return;
        }
        StringBuilder b = new StringBuilder();
        b.append("<ol>");
        for(Map.Entry<String, String> item : list.entrySet()){
            b.append("<li><b>");
            b.append(item.getKey());
            b.append(":</b>");
            b.append(" ").append(item.getValue())
                    .append("</li>");
        }
        b.append("</ol>");
        System.out.println(b);
    }
}