package network.urlreader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleUrlReader {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://google.com");
        try (InputStream input = url.openStream()) {
            byte[] buffer = input.readAllBytes();
            String str = new String(buffer);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
