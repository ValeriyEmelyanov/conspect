package io.char_streams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CopyChars {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("First argument - source file, second argument - target file.");
            return;
        }

//        try (FileReader reader = new FileReader(args[0]);
//             FileWriter writer = new FileWriter(args[1]);) {
        try (Reader reader = new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8);
             Writer writer = new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8);) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
