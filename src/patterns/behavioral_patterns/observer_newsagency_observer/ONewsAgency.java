package patterns.behavioral_patterns.observer_newsagency_observer;

import java.util.Observable;

public class ONewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}
