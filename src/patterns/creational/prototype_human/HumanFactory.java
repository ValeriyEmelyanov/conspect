package patterns.creational.prototype_human;

public class HumanFactory {
    private Human human;

    public HumanFactory(Human human) {
        this.human = human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public Human makeCopy() {
        return (Human) human.copy();
    }
}
