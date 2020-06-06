package patterns.behavioral_patterns.strategy_sending_messages;

public interface Sender {
    void send(String from, String to, String msg);
}
