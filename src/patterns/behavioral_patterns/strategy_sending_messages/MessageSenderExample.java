package patterns.behavioral_patterns.strategy_sending_messages;

/**
 * An application needs to send messages to the customers.
 * There are different ways to reach out to them: via SMS or e-mail.
 * In addition, new sending methods will be added in future.
 * Each algorithm must encapsulate a logic to send a message using a concrete transport (SMS/email).
 * The Context is MessageSender which references a specific sending and allows to change the currently transport.
 *
 * In the client code, we should create an instance of MessageSender,
 * set a sender and invoke the method send with arguments.
 */
public class MessageSenderExample {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();
        sender.setSender(new EmailSender());
        sender.send("alice@gmail.com", "bob@gmail.com", "Hello!");
        sender.setSender(new SmsSender());
        sender.send("1-541-444-3333", "1-541-555-2222", "Hello!");
    }
}
