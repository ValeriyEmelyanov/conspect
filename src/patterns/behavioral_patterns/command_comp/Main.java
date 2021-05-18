package patterns.behavioral_patterns.command_comp;

public class Main {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(
                new CommandStart(comp),
                new CommandStop(comp),
                new CommandReset(comp)
        );

        user.startComp();
        user.resetComp();
        user.stopComp();
    }
}
