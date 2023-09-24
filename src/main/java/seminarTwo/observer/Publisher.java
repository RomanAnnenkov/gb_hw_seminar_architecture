package seminarTwo.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements IPublisher {
    private final List<IObserver> observers = new ArrayList<>();

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (IObserver o : observers) {
            o.update(message);
        }
    }
}
