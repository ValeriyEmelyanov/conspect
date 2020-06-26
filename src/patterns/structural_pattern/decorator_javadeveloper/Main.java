package patterns.structural_pattern.decorator_javadeveloper;

public class Main {
    public static void main(String[] args) {
        Developer developer = new JavaTeamLead(
                new SeniorJavaDeveloper(
                        new JavaDeveloper()));
        System.out.println(developer.makeJob());
    }
}
