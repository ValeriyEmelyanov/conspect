package network.filedownload;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FileDownload {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Incorrect parameters! Parameters: first - url, second - target.");
            return;
        }

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try  {
            URL url = new URL(args[0]);
            URLConnection connection = url.openConnection();

            inputStream = connection.getInputStream();
            outputStream = new FileOutputStream(args[1]);

            System.out.println("Downloading ...");
            byte[] buffer = new byte[1024 * 4];
            int len;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            System.out.println("Completed.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
