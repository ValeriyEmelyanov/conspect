package io.cloning;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestDrive {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Cloneable
        Point point1 = new Point(10, 20);
        System.out.println("Source before: " + point1);

        Point clone1 = point1.clone();
        System.out.println("Source after clone made: " + point1);
        System.out.println("Clone: " + clone1);

        clone1.setX(12);
        System.out.println("Source after clone changed: " + point1);
        System.out.println("Clone: " + clone1);
        System.out.println("");

        // Own clone implementation
        FldPoint point2 = new FldPoint(1, 3);
        System.out.println("Source before: " + point2);

        FldPoint clone2 = point2.clone();
        System.out.println("Source after clone made: " + point2);
        System.out.println("Clone: " + clone2);

        clone2.setX(0);
        System.out.println("Source after clone changed: " + point2);
        System.out.println("Clone: " + clone2);
        System.out.println("");

        // Serialization
        SerializablePoint point3 = new SerializablePoint(100, 200);
        System.out.println("Source before: " + point3);

        SerializablePoint clone3 = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream ous = new ObjectOutputStream(baos)) {
            ous.writeObject(point3);
            ous.flush();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                clone3 = (SerializablePoint) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (clone3 != null) {
            System.out.println("Source after clone made: " + point3);
            System.out.println("Clone: " + clone3);

            clone3.setX(101);
            System.out.println("Source after clone changed: " + point3);
            System.out.println("Clone: " + clone3);
            System.out.println("");
        }

        // Deep clone
        ExtPoint point4 = new ExtPoint(30, 31, new Group(1));
        System.out.println("Source before: " + point4);

        ExtPoint clone4 = point4.clone();
        System.out.println("Source after clone made: " + point4);
        System.out.println("Clone: " + clone4);

        clone4.setX(40);
        clone4.getGroup().setId(2);
        System.out.println("Source after group and clone changed: " + point4);
        System.out.println("Clone: " + clone4);
        System.out.println("");
    }
}
