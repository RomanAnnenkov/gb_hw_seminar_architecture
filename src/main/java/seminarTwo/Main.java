package seminarTwo;

import seminarTwo.decorator.Drawable;
import seminarTwo.decorator.GreenDrawableDecorator;
import seminarTwo.decorator.Triangle;

public class Main {
    public static void main(String[] args) {
        Drawable triangle = new Triangle();
        triangle.draw();
        Drawable greenTriangle = new GreenDrawableDecorator(new Triangle());
        greenTriangle.draw();

        
    }
}
