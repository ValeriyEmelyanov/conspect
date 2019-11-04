package patterns.behavioral_patterns.chain_of_responsibility_rush;

public interface Logger {
    void inform(String message, int level);
    void setNext(Logger next);
    void info(String message);
}
