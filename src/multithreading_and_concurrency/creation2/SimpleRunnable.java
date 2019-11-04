package multithreading_and_concurrency.creation2;

public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Вывод сообщения из класса, реализующего интерфейс Runnable!");
    }
}
