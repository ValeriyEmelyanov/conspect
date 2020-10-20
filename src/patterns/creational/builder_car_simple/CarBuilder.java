package patterns.creational.builder_car_simple;

public class CarBuilder {
    String make = "Default";
    Transmission transmission = Transmission.MANUAL;
    int maxSpeed = 120;

    public CarBuilder buildMake(String make) {
        this.make = make;
        return this;
    }

    public CarBuilder buildTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder buildmaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Car build() {
        Car car = new Car();
        car.setMake(make);
        car.setTransmission(transmission);
        car.setMaxSpeed(maxSpeed);
        return car;
    }
}
