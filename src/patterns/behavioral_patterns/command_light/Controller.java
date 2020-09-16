package patterns.behavioral_patterns.command_light;

import patterns.behavioral_patterns.command_light.command.Command;

/**
 * Invoker
 */
public class Controller {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
