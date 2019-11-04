package patterns.behavioral_patterns.observer_newsagency_observer;

import java.util.Observable;
import java.util.Observer;

public class ONewsChannel implements Observer {
    private String news;

    public void setNews(String news) {
        this.news = news;
        System.out.println(news);
    }

    @Override
    public void update(Observable o, Object arg) {
        setNews((String) arg);
    }
}
