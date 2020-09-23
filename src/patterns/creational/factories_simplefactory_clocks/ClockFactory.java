package patterns.creational.factories_simplefactory_clocks;

public class ClockFactory {

    private boolean produceToyClock;

    public ClockFactory(boolean produceToyClock) {
        this.produceToyClock = produceToyClock;
    }

    /**
     * It produces a clock according to a specified type: SAND, DIGITAL or MECH.
     * If some other type is passed, the method produces ToyClock.
     */
    public Clock produce(String type) {
        switch (type.toUpperCase()) {
            case "SAND":
                return new SandClock();
            case "DIGITAL":
                return new DigitalClock();
            case "MECH":
                return new MechanicalClock();
            default:
                if (produceToyClock) {
                    return new ToyClock();
                } else {
                    return null;
                }
        }
    }
}
