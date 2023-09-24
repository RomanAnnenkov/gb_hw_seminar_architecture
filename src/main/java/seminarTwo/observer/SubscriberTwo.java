package seminarTwo.observer;

public class SubscriberTwo implements IObserver {
    @Override
    public void update(String message) {
        System.out.println("SubscriberTwo get: " + message);
    }
}
