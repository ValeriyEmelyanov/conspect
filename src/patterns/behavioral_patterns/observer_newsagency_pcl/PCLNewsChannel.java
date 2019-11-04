package patterns.behavioral_patterns.observer_newsagency_pcl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PCLNewsChannel implements PropertyChangeListener {
    private String news;

    public void setNews(String news) {
        this.news = news;
        System.out.println(news);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setNews((String) evt.getNewValue());
    }
}
