package io.character_streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("First argument - source file, second argument - target file.");
            return;
        }

        try (FileReader reader = new FileReader(args[0]);
             FileWriter writer = new FileWriter(args[1]);) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
