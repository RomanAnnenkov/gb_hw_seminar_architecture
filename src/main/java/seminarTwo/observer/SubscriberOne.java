package seminarTwo.observer;

public class SubscriberOne implements IObserver {
    @Override
    public void update(String message) {
        System.out.println("SubscriberOne get: " + message);
    }
}
