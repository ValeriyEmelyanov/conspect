package regexp.text_analysis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong number of arguments!");
            return;
        }

        String text = readFile(args[0]);

        int sentences = text.split("[?.!]").length;

        String[] wordsArr = text.replaceAll("[.!?]", "").split("[\\s\\p{Z}\\p{Space}\\p{Blank}]+");
        int words = wordsArr.length;

        long characters =  text.chars()
                .filter(c -> c != ' ' && c != '\n' && c != '\u00A0' && c != '\t')
                .count();

        int syllables = 0;
        int polysyllables = 0;
        int count;
        Pattern pattern = Pattern.compile("[aeiouyAEIOUY]{1,3}");
        Matcher matcher;
        for (String word : wordsArr) {
            if (word.endsWith("e")) {
                word = word.substring(0, word.length() - 1);
            }
            matcher = pattern.matcher(word);
            count = 0;
            while (matcher.find()) {
                count++;
            }
            syllables += count == 0 ? 1 : count;
            polysyllables += count > 2 ? 1 : 0;
        }

        System.out.println(String.format("Words: %d", words));
        System.out.println(String.format("Sentences: %d", sentences));
        System.out.println(String.format("Characters: %d", characters));
        System.out.println(String.format("Syllables: %d", syllables));
        System.out.println(String.format("Polysyllables: %d", polysyllables));
    }

    private static String readFile(String filename) {
        try {
            return Files.readString(Path.of(filename));
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file!");
        }
    }
}
