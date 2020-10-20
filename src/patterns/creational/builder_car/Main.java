package patterns.creational.builder_car;

import patterns.creational.builder_car.builders.FordMondeoBuilder;
import patterns.creational.builder_car.car.Car;
import patterns.creational.builder_car.director.Director;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new FordMondeoBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}
