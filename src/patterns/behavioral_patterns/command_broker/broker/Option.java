package patterns.behavioral_patterns.command_broker.broker;

public class Option {
    private int amount;

    public Option(int amount) {
        this.amount = amount;
    }

    public void buy() {
        System.out.println(amount + " was bought");
    }

    public void sell() {
        System.out.println(amount + " was sold");
    }
}
