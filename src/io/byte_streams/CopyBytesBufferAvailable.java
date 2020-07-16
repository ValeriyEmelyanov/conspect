package io.byte_streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesBufferAvailable {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("First argument - source file, second argument - target file.");
            return;
        }

        String src = args[0];
        String dest = args[1];

        final int bufferSize = 65536; // 64 Kb

        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[bufferSize];
            while (in.available() > 0) {
                int real = in.read(buffer);
                out.write(buffer, 0, real);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
