package io.to_stringwriter;

import java.io.StringWriter;

public class Main {
    public static void main(String[] args) {
        StringWriter writer = new StringWriter();
        writer.write("Hello world!\n");
        writer.write("With best regards from StringWriter");
        String result = writer.toString();
        System.out.println(result);
    }
}
