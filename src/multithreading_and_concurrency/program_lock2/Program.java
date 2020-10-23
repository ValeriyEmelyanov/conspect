package multithreading_and_concurrency.program_lock2;

public class Program {
    public static void main(String[] args) {
        SharedObject num = new SharedObject();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CountThread(num));
            thread.setName("Thread " + i);
            thread.start();
        }
    }
}
