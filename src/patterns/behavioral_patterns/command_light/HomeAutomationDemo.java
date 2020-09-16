package patterns.behavioral_patterns.command_light;

import patterns.behavioral_patterns.command_light.command.Command;
import patterns.behavioral_patterns.command_light.command.LightOffCommand;
import patterns.behavioral_patterns.command_light.command.LightOnCommand;

public class HomeAutomationDemo {
    public static void main(String[] args) {

        /*
         * 1. Creating an object from the invoker class which is Controller in our application.
         */
        Controller controller = new Controller();

        /*
         * Creating a Light object because a Light object is needed to pass to create Command objects.
         */
        Light light = new Light();

        /*
         * 2. Creating objects from commands that we are going to execute.
         */
        Command lightOn = new LightOnCommand(light);
        Command lightoff = new LightOffCommand(light);

        /*
         * 3. Executing commands using invokers.
         */
        controller.setCommand(lightOn);
        controller.executeCommand();

        controller.setCommand(lightoff);
        controller.executeCommand();
    }
}
