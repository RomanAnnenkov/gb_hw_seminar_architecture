package seminarTwo.observer;

public interface IPublisher {
    void attach(IObserver observer);

    void detach(IObserver observer);

    void notify(String message);

}
