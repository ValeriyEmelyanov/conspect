package patterns.behavioral_patterns.observer_weatherstation;

public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
