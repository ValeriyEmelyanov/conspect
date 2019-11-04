package patterns.miscellaneous.service_locator;

public class EJBServiceImpl implements Service {
    @Override
    public String getName() {
        return "EJBService";
    }

    @Override
    public void execute() {
        System.out.println("Executing the EJBService");
    }
}
