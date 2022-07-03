package regexp.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Task: you need to find all dates in two different formats: yyyy-mm-dd and yyyy/mm/dd.
 * Solution: \d{4}([-/])\d{2}\1\d{2}
 * - search for 4 digits and then for one of separators: \d{4}([-/])
 * - look for two digits and the same delimiter that has been already found: \d{2}\1
 *   With \1 we refer to the first group we encountered in the regex: ([-/]).
 * - search for two digits: \d{2}
 */
public class FindingDatesWithGroupDelimiter {
    public static void main(String[] args) {
        String input = "Date 1: 2022-06-06 Date 2: 2021/01/01; date 3: 2020-02-02";

        String sPattern = "\\d{4}([-/])\\d{2}\\1\\d{2}";
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher =pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(input.substring(matcher.start(), matcher.end()));
        }

        /* Kotlin
        val input = "Date 1: 2022-06-06 Date 2: 2021/01/01; date 3: 2020-02-02"
        val regex = Regex("""\d{4}([-/])\d{2}\1\d{2}""")
        val dates = regex.findAll(input)
        for (date in dates) println(date.value)
         */
    }
}
