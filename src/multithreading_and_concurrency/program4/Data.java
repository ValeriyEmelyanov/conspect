package multithreading_and_concurrency.program4;

/**Data class that consists of the data packet that will be sent from Sender to Receiver.
 * */
public class Data {
    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        transfer = false;
        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        transfer = true;
        notifyAll();
        return packet;
    }
}
