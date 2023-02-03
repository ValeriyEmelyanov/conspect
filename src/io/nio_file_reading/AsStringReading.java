package io.nio_file_reading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AsStringReading {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("text2.txt");
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
