package multithreading_and_concurrency.creation1;

/** Создание потока наследованием от класса Thread.
 * */
public class Program {
    public static void main(String[] args) {
        SimpleThread thread = new SimpleThread();
        thread.start();

        System.out.println("Главный поток завершен.");
    }
}
