package patterns.behavioral_patterns.delegation_car;

/*
Делегирование (Delegation) является поведенческим (behavioral) паттерном проектрования,
в котором объект внешне выражает некоторое поведение,
но в реальности передаёт ответственность за выполнение этого поведения связанному объекту.
 */
public class App {
    public static void main(String[] args) {
        final String rider = "Alex";
        CarController bmw = new CarController(new BmwCar());
        CarController mercedes = new CarController(new MercedesCar());
        CarController volvo = new CarController(new VolvoCar());

        bmw.ride(rider);
        mercedes.ride(rider);
        volvo.ride(rider);
    }
}
