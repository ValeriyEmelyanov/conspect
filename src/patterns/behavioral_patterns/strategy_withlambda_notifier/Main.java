package patterns.behavioral_patterns.strategy_withlambda_notifier;

public class Main {
    public static void main(String[] args) {
        Application app = new Application(new EmailServiceImpl(), new SMSServiceImpl());
        app.run(new User("ee@ee.ru", "12345"));
    }
}
