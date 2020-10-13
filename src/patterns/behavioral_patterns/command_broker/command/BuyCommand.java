package patterns.behavioral_patterns.command_broker.command;

import patterns.behavioral_patterns.command_broker.broker.Option;

public class BuyCommand implements Command {
    private Option option;

    public BuyCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.buy();
    }
}
