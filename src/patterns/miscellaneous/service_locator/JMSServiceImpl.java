package patterns.miscellaneous.service_locator;

public class JMSServiceImpl implements Service {
    @Override
    public String getName() {
        return "JMSService";
    }

    @Override
    public void execute() {
        System.out.println("Executing the JMSService");
    }
}
