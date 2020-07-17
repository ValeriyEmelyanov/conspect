package io.char_streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class CopyCharsReady {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("First argument - source file, second argument - target file.");
            return;
        }

        String src = args[0];
        String dest = args[1];

        final int bufferSize = 65536; // 128 Kb

        try (FileReader reader = new FileReader(src, Charset.forName("Windows-1252"));
             FileWriter writer = new FileWriter(dest, Charset.forName("Windows-1252"))) {
            char[] buffer = new char[bufferSize];
            while (reader.ready()) {
                int real = reader.read(buffer);
                writer.write(buffer, 0, real);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
