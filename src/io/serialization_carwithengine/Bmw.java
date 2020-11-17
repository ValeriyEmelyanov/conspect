package io.serialization_carwithengine;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Bmw extends Car implements Serializable {
    private int price;
    private String model;
    private transient Engine engine;

    public Bmw(int weight, int price, String model, Engine engine) {
        super(weight);
        this.price = price;
        this.model = model;
        this.engine = engine;
    }

    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            oos.writeInt(engine.getPower());
            oos.writeObject(engine.getProducer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            this.engine = new Engine(ois.readInt(), (String) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Bmw{" +
                "weight=" + super.getWeight() +
                "price=" + price +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }

}
