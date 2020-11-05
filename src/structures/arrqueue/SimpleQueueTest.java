package structures.arrqueue;

public class SimpleQueueTest {
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue(10);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);

        while (!queue.isEmpty()) {
            long n = queue.remove();
            System.out.println(n);
        }
    }
}
