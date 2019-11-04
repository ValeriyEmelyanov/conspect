package patterns.behavioral_patterns.chain_of_responsibility_rush;

public class PhoneLogger extends AbstractLogger {
    public PhoneLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Call to director: " + message);
    }
}
