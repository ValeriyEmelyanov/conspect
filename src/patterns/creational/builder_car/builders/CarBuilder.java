package patterns.creational.builder_car.builders;

import patterns.creational.builder_car.car.Car;

public abstract class CarBuilder {
    protected Car car;

    public void createCar() {
        car = new Car();
    }

    public abstract void buildMake();
    public abstract void buildTransmission();
    public abstract void buildMaxSpeed();

    public Car getCar() {
        return  car;
    }
}
