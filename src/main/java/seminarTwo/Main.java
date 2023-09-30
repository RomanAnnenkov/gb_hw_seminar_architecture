package seminarTwo;

import seminarTwo.decorator.Drawable;
import seminarTwo.decorator.GreenDrawableDecorator;
import seminarTwo.decorator.Triangle;
import seminarTwo.observer.Publisher;
import seminarTwo.observer.SubscriberOne;
import seminarTwo.observer.SubscriberTwo;

public class Main {
    public static void main(String[] args) {
        Drawable triangle = new Triangle();
        triangle.draw();
        Drawable greenTriangle = new GreenDrawableDecorator(new Triangle());
        greenTriangle.draw();

        SubscriberOne subscriberOne = new SubscriberOne();
        SubscriberTwo subscriberTwo = new SubscriberTwo();
        Publisher publisher = new Publisher();

        publisher.attach(subscriberOne);
        publisher.attach(subscriberTwo);

        publisher.notify("test message");

    }
}
