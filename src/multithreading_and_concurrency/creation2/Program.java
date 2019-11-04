package multithreading_and_concurrency.creation2;

/** Создание потока с помощью класса реализующего интерфейс Runnable.
 * */
public class Program {
    public static void main(String[] args) {
        Runnable myRunnable = new SimpleRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        System.out.println("Главный поток завершен.");
    }
}
