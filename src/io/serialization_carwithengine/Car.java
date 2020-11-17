package io.serialization_carwithengine;

import java.io.Serializable;

public abstract class Car implements Serializable {
    private int weight;

    public Car(int weight) {
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
