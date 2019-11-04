package patterns.behavioral_patterns.chain_of_responsibility_rush2.space.crew;

public class Captain extends AbstractCrewMember {
    public Captain (AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doTheJob(String request) {
        System.out.println("Only the captain can handle request " + request + ". Let's do this!");
    }
}
