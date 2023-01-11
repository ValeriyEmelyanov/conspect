package patterns.behavioral_patterns.strategy_withlambda_notifier;

public class SMSServiceImpl implements SMSService {
    @Override
    public void sendSMS(User user) {
        System.out.println("sending sms to " + user.getPhoneNumber());
    }
}
