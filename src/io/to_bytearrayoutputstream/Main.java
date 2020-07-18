package io.to_bytearrayoutputstream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (PrintStream stream = new PrintStream(baos)) {
            stream.println("Hello world!");
            stream.println("With best regards from ByteArrayOutputStream");
        }
        String result = baos.toString();
        System.out.println(result);
    }
}
