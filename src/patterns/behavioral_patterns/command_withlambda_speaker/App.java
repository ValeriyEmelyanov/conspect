package patterns.behavioral_patterns.command_withlambda_speaker;

import java.util.ArrayList;
import java.util.List;

public class App {
    private final List<Command> commands;

    public App() {
        this.commands = new ArrayList<>();
    }

    public void add(Command command) {
        commands.add(command);
    }

    public void run() {
        for (Command command: commands) {
            command.execute();
        }
    }
}
