package patterns.behavioral_patterns.observer_weatherstation;

public interface Observer {
    void update(float temperature, float humidity, int pressure);
}
