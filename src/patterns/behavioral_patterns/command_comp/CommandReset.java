package patterns.behavioral_patterns.command_comp;

/**
 * Concrete command
 */
public class CommandReset implements Command {
    private final Comp comp;

    public CommandReset(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.reset();
    }
}
