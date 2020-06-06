package patterns.behavioral_patterns.strategy_sending_messages;

public class SmsSender implements Sender {

    @Override
    public void send(String from, String to, String msg) {
        System.out.println(String.format("Send SMS from '%s' to '%s'", from, to));
    }

}
