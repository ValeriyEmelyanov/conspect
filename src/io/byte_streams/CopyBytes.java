package io.byte_streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Programs use byte streams to perform input and output of 8-bit bytes.
 */
public class CopyBytes {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("First argument - source file, second argument - target file.");
            return;
        }

        try (FileInputStream in = new FileInputStream(args[0]);
             FileOutputStream out = new FileOutputStream(args[1])) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
