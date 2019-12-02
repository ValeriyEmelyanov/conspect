package io.properties_store;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String rootPath = Objects.requireNonNull(
                Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String packagePath = rootPath + Main.class.getPackage().getName().replace(".", "/");
        String newAppPath = packagePath + "/newApp.properties";

        try (FileWriter fileWriter = new FileWriter(newAppPath)) {

            Properties appProps = new Properties();

            appProps.setProperty("db.host", "http://localhost:8888/mydb");
            appProps.setProperty("db.login", "root");
            appProps.setProperty("db.password", "123");

            appProps.store(fileWriter, "Stored config");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
