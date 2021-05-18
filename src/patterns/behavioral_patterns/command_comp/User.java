package patterns.behavioral_patterns.command_comp;

/**
 * Invoker
 */
public class User {
    private final Command start;
    private final Command stop;
    private final Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    public void startComp() {
        start.execute();
    }

    public void stopComp() {
        stop.execute();
    }

    public void resetComp() {
        reset.execute();
    }
}
