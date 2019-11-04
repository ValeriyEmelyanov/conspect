package patterns.behavioral_patterns.chain_of_responsibility_rush;

public class SmsLogger extends AbstractLogger {
    public SmsLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Send SMS to CEO: " + message);
    }
}
