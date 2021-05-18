package patterns.behavioral_patterns.command_comp;

/**
 * Concrete command
 */
public class CommandStart implements Command {
    private final Comp comp;

    public CommandStart(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.start();
    }
}
