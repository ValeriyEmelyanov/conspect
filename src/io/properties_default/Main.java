package io.properties_default;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String rootPath = Objects.requireNonNull(
                Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String packagePath = rootPath + Main.class.getPackage().getName().replace(".", "/");
        String defaultPath = packagePath + "/default.properties";
        String appPath = packagePath + "/app.properties";

        try (FileInputStream defaultFis = new FileInputStream(defaultPath);
             FileInputStream appFis = new FileInputStream(appPath);) {

            Properties defaultProps= new Properties();
            defaultProps.load(defaultFis);

            Properties appProps = new Properties(defaultProps);
            appProps.load(appFis);

            String host = appProps.getProperty("db.host");
            String login = appProps.getProperty("db.login");
            String password = appProps.getProperty("db.password");
            String comment = appProps.getProperty("comment");

            System.out.println("Host: " + host);
            System.out.println("Login: " + login);
            System.out.println("Password: " + password);
            System.out.println("Comment: " + comment);

            System.out.println("===");

            appProps.remove("db.host");
            host = appProps.getProperty("db.host");

            System.out.println("Host: " + host);
            System.out.println("Login: " + login);
            System.out.println("Password: " + password);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
