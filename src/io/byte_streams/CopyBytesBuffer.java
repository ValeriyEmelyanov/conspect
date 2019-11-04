package io.byte_streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesBuffer {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("First argument - source file, second argument - target file.");
            return;
        }

        try (FileInputStream in = new FileInputStream(args[0]);
             FileOutputStream out = new FileOutputStream(args[1])) {
            byte[] bytes = new byte[BUFFER_SIZE];
            int len;
            while ((len = in.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
