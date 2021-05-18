package patterns.behavioral_patterns.command_comp;

/**
 * Concrete command
 */
public class CommandStop implements Command {
    private final Comp comp;

    public CommandStop(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.stop();
    }
}
