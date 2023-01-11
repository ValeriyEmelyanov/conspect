package patterns.behavioral_patterns.strategy_withlambda_notifier;

public class Application {
    private final EmailService emailService;
    private final SMSService smsService;

    public Application(EmailService emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void run(User user) {
        Notifier notifier = new Notifier(u -> emailService.sendEmail(u));
        notifier.notifyCustomer(user);
        notifier.setStrategy(u -> smsService.sendSMS(u));
        notifier.notifyCustomer(user);
    }
}
