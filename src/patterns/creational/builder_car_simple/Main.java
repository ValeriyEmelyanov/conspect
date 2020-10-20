package patterns.creational.builder_car_simple;

public class Main {

    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("Mercedes")
                .buildTransmission(Transmission.AUTO)
                .buildmaxSpeed(240)
                .build();
        System.out.println(car);
    }

}
