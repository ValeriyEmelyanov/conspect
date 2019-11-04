package patterns.behavioral_patterns.observer_newsagency;

public class Program {
    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();
        observable.addObserver(observer);

        observable.setNews("Fresh news");
    }

}
