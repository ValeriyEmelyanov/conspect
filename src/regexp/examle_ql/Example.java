package regexp.examle_ql;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * "Свой" язык запросов и парсер
 *
 * Парсит выражение вида:
 * get field1 for field2 = "value1" and field3 = "value2" and date between "after" and "before"
 */
public class Example {
    public static void main(String[] args) {
        // Примеры
        parseQuery("get ip");
        parseQuery("get ip for user = \"Eduard Petrovich Morozko\"");
        parseQuery("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"");
        parseQuery("get event for user = \"Vasya Pupkin\" and date between \"30.08.2012 16:08:39\" and \"30.08.2012 16:08:41\"");
    }

    private static void parseQuery(String query) {
        Pattern pattern = Pattern.compile("get (?<tag>\\w+)" +
                "(\\sfor\\s(?<field>\\w+)\\s=\\s\"(?<value>.+?)\")?" +
                "(\\sand date between\\s\"(?<after>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\"\\sand\\s\"(?<before>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\")?");
        Matcher matcher = pattern.matcher(query);

        if (!matcher.find()) {
            return;
        }

        String tag = matcher.group("tag");
        String field = matcher.group("field");
        String value = matcher.group("value");
        String after = matcher.group("after");
        String before = matcher.group("before");

        System.out.println();
        System.out.println("tag: " + tag);
        System.out.println("field: " + field);
        System.out.println("value: " + value);
        System.out.println("after: " + after);
        System.out.println("before: " + before);
    }
}
