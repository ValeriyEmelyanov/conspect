package regexp.replacement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) {
        String src = "In JavaRush, Diego the best, Diego is Java God";

        Pattern pattern = Pattern.compile("\\s[a-zA-Z]{5}\\s");
        Matcher matcher = pattern.matcher(src);
        String result = matcher.replaceAll(" Amigo ");

        System.out.println(src);
        System.out.println(result);
    }
}
