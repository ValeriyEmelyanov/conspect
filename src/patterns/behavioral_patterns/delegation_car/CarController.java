package patterns.behavioral_patterns.delegation_car;

public class CarController implements Car {
    private final Car car;

    public CarController(Car car) {
        this.car = car;
    }

    @Override
    public void ride(String name) {
        car.ride(name);
    }
}
