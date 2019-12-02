package io.properties_simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        //String rootPath = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1);
        String rootPath = Objects.requireNonNull(
                Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String configPath = rootPath + Main.class.getPackage().getName().replace(".", "/") + "/config.properties";

        try (FileInputStream fis = new FileInputStream(configPath);) {
            Properties properties = new Properties();
            properties.load(fis);

            String host = properties.getProperty("db.host");
            String login = properties.getProperty("db.login");
            String password = properties.getProperty("db.password");
            String comment = properties.getProperty("comment", "No comment");

            System.out.println("Host: " + host);
            System.out.println("Login: " + login);
            System.out.println("Password: " + password);
            System.out.println("Comment: " + comment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
