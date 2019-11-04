package patterns.behavioral_patterns.observer_newsagency_pcl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PCLNewsAgency {
    private String news;
    private PropertyChangeSupport support;

    public PCLNewsAgency() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    private void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void setNews(String value) {
        support.firePropertyChange("news", news, value);
        news = value;
    }
}
