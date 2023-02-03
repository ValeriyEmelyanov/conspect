package io.nio_file_reading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class AllLineReading {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("text2.txt");
            Stream<String> stringStream = Files.lines(path);
            stringStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
