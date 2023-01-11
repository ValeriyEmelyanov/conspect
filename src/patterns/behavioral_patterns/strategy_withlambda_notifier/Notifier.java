package patterns.behavioral_patterns.strategy_withlambda_notifier;

public class Notifier {
    private NotificationStrategy strategy;

    Notifier(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void notifyCustomer(User user) {
        strategy.notifyCustomer(user);
    }
}
