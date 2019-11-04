package patterns.behavioral_patterns.chain_of_responsibility;

public class StderrLogger extends Logger {
    public StderrLogger(int mask) {
        this.mask = mask;
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("Sending to stderr: " + msg);
    }
}
