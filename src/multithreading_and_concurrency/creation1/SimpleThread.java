package multithreading_and_concurrency.creation1;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        System.out.println("Вывод сообщения из моего потока!");
    }
}
