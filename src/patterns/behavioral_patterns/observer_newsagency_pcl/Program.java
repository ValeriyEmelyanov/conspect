package patterns.behavioral_patterns.observer_newsagency_pcl;

public class Program {
    public static void main(String[] args) {
        PCLNewsAgency observable = new PCLNewsAgency();
        PCLNewsChannel observer = new PCLNewsChannel();
        observable.addPropertyChangeListener(observer);

        observable.setNews("Good news!");
    }
}
