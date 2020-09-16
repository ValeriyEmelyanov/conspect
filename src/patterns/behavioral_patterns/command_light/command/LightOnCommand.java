package patterns.behavioral_patterns.command_light.command;

import patterns.behavioral_patterns.command_light.Light;

/**
 * Concrete command
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
