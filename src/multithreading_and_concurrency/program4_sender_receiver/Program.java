package multithreading_and_concurrency.program4_sender_receiver;

/** Simple Sender–Receiver application – that will make use of the wait() and notify() methods
 * to set up synchronization between them:
 * - The Sender is supposed to send a data packet to the Receiver
 * - The Receiver cannot process the data packet until the Sender is finished sending it
 * - Similarly, the Sender mustn’t attempt to send another packet unless
 * the Receiver has already processed the previous packet
 * */
public class Program {
    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));
        sender.start();
        receiver.start();
    }
}
