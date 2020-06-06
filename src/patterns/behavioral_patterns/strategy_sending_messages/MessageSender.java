package patterns.behavioral_patterns.strategy_sending_messages;

public class MessageSender {

    private Sender sender;

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public void send(String from, String to, String msg) {
        this.sender.send(from, to, msg);
    }
}
