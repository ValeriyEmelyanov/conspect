package patterns.creational.builder_car.director;

import patterns.creational.builder_car.builders.CarBuilder;
import patterns.creational.builder_car.car.Car;

public class Director {
    private CarBuilder builder;

    public void setBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    public Car buildCar() {
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        return builder.getCar();
    }
}
