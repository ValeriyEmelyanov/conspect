package io.buffered_streams;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLines {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("First argument - source file, second argument - target file.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             PrintWriter writer = new PrintWriter(new FileWriter(args[1]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
