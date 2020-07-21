package network.filedownload;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class UrlFileDownloader {
    public static void main(String[] args) throws MalformedURLException {
        String img = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
        URL url = new URL(img);
        try (InputStream input = url.openStream()) {
            Path path = Path.of("C:\\Temp\\GoogleLogo.png");
            Files.copy(input, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
