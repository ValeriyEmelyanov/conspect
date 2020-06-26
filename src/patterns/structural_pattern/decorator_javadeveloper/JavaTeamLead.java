package patterns.structural_pattern.decorator_javadeveloper;

public class JavaTeamLead extends DeveloperDecorator {

    public JavaTeamLead(Developer developer) {
        super(developer);
    }

    public String sendWeekReport() {
        return "Send week report to customers.";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + " " + sendWeekReport();
    }
}
