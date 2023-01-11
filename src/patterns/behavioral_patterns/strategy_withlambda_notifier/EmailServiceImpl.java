package patterns.behavioral_patterns.strategy_withlambda_notifier;

public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(User user) {
        System.out.println("sending email to " + user.getEmail());
    }
}
