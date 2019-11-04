package patterns.behavioral_patterns.observer_newsagency_observer;

public class Program {
    public static void main(String[] args) {
        ONewsAgency observable = new ONewsAgency();
        ONewsChannel observer = new ONewsChannel();
        observable.addObserver(observer);

        observable.setNews("Some news");
    }
}
