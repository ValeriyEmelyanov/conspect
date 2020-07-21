package network.urlreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebSiteReader {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        {
            try {
                URL url = new URL("http://google.com");
                URLConnection connection = url.openConnection();

                inputStreamReader = new InputStreamReader(connection.getInputStream(), "UTF8");
                bufferedReader = new BufferedReader(inputStreamReader);

                String nextLine;
                while ((nextLine = bufferedReader.readLine()) != null) {
                    System.out.println(nextLine);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
