package io.buffered_streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class CopyLinesReady {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("First argument - source file, second argument - target file.");
            return;
        }

        String src = args[0];
        String dest = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(src, Charset.forName("Windows-1252")));
             PrintWriter writer = new PrintWriter(new FileWriter(dest, Charset.forName("Windows-1252")))) {
            while (reader.ready()) {
                writer.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
