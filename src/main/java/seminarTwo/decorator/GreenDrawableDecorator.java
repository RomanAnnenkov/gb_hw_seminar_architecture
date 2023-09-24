package seminarTwo.decorator;

public class GreenDrawableDecorator extends DrawableDecorator {
    public GreenDrawableDecorator(Drawable decoratedDrawable) {
        super(decoratedDrawable);
    }

    @Override
    public void draw() {
        decoratedDrawable.draw();
        setGreenBorder(decoratedDrawable);
    }

    private void setGreenBorder(Drawable decoratedDrawable) {
        System.out.println("Set border to green.");
    }
}
