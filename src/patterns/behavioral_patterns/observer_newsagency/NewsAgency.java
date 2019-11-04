package patterns.behavioral_patterns.observer_newsagency;

import java.util.ArrayList;
import java.util.List;

/**
 * An observable is an object which notifies observers about the changes in its state.
 *
 * A news agency can notify channels when it receives news.
 * Receiving news is what changes the state of the news agency, and it causes the channels to be notified.
 */
public class NewsAgency {
    private String news;
    private List<Channel> channels = new ArrayList<>();

    public void addObserver(Channel channel) {
        channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        channels.remove(channel);
    }

    /**
     * NewsAgency is an observable, and when news gets updated, the state of NewsAgency changes.
     * When the change happens, NewsAgency notifies the observers about this fact by calling their update() method.
     */
    public void setNews(String news) {
        this.news = news;
        for (Channel channel : channels) {
            channel.update(this.news);
        }

    }
}
