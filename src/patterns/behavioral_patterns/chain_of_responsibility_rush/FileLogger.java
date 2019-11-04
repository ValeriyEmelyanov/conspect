package patterns.behavioral_patterns.chain_of_responsibility_rush;

public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to file: " + message);
    }
}
