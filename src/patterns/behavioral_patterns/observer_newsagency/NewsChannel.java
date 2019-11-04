package patterns.behavioral_patterns.observer_newsagency;

public class NewsChannel implements Channel {
    private String news;

    public void setNews(String news) {
        this.news = news;
        System.out.println(this.news);
    }

    @Override
    public void update(Object o) {
        setNews((String) o);
    }
}
