package io.externalizable_student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Externalizable - пользовательская сериализация
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Alex");
        File file = new File("C:/tmp/student.txt");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));) {
            out.writeObject(student);
            out.flush();

            Student restored = (Student) in.readObject();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
