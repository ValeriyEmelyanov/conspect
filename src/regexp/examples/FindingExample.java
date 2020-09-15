package regexp.examples;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindingExample {
    public static void main(String[] args) {

        // the find method of Matcher can check whether a substring of a string matches the pattern.
        String javaText = "Java supports regular expressions. LET'S USE JAVA!!!";

        Pattern javaPattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(javaText);

        System.out.println(matcher.find()); // prints "true"

        // When find() method returns true
        // it is possible to get some info about the substring matching the pattern.
        // start() and end() return the starting and the last indices of the match respectively
        // group() returns the matching substring itself
        if (matcher.find()) {
            System.out.println(matcher.start()); // 0, the starting index of match
            System.out.println(matcher.end());   // 4, the index followed the last index of match
            System.out.println(matcher.group()); // "Java", a substring that matches the pattern
        } else {
            System.out.println("No matches found");
        }

        // Class MatchResult comprises all this information about the match
        MatchResult result = matcher.toMatchResult(); // a special object containing match results

        System.out.println(result.start()); // 0
        System.out.println(result.end());   // 4
        System.out.println(result.group()); // "Java"

        // Iterating over multiple matches
        while (matcher.find()) {
            System.out.println("group: " + matcher.group() + ", start: " + matcher.start());
        }

    }
}
