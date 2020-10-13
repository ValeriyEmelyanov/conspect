package patterns.behavioral_patterns.command_broker.broker;

import patterns.behavioral_patterns.command_broker.command.Command;

public class Broker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
