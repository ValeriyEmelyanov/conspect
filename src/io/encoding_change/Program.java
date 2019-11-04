package io.encoding_change;

import java.io.*;

/**
 * Как поменять кодировку файла?
 * В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
 * В метод main вторым параметром приходит имя файла,
 * в который необходимо записать содержимое первого файла в кодировке UTF-8.
 */
public class Program {
    private final static int BUFFER_SIZE = 1024 * 4;

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[0]);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "windows-1251");
             FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8")) {
            char[] buffer = new char[BUFFER_SIZE];
            int readed;
            while ((readed = inputStreamReader.read(buffer, 0, BUFFER_SIZE)) > 0) {
                outputStreamWriter.write(buffer, 0, readed);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
