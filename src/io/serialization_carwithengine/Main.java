package io.serialization_carwithengine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        File file = new File("c:/tmp/car.txt");
        Bmw bmw = new Bmw(1000, 50_000, "x6", new Engine(1500, "BMW"));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
            oos.writeObject(bmw);
            oos.flush();

            Bmw restored = (Bmw) ois.readObject();
            System.out.println(restored);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
