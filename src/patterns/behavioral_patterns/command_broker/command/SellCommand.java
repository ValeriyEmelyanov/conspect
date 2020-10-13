package patterns.behavioral_patterns.command_broker.command;

import patterns.behavioral_patterns.command_broker.broker.Option;

public class SellCommand implements Command {
    Option option;

    public SellCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.sell();
    }
}
