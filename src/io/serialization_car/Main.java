package io.serialization_car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        String fileName = "c:/tmp/car.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) {
            Car car = new Car("BMW", 50_000);
            oos.writeObject(car);
            oos.flush();

            Car restored = (Car) ois.readObject();
            System.out.println(restored);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
