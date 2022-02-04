package patterns.behavioral_patterns.delegation_car;

public class BmwCar implements Car {

    @Override
    public void ride(String name) {
        System.out.println(name + " rides in BMW");
    }
}
