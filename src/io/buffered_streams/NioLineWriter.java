package io.buffered_streams;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NioLineWriter {
    public static void main(String[] args) throws IOException {
        // Вариант 1
        String fileName = "D:\\Work\\out.txt";
        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(fileName), StandardCharsets.UTF_8)) {
            writer.write("Hello");
            writer.newLine();
        }

        // Вариант 2 для небольших файлов
        String fileName2 = "D:\\Work\\out2.txt";
        List<String> lines = List.of("Hello", "World");
        Files.write(Paths.get(fileName2), lines, StandardCharsets.UTF_8);
    }
}
