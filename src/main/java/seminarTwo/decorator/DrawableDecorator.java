package seminarTwo.decorator;

public abstract class DrawableDecorator implements Drawable {
    protected final Drawable decoratedDrawable;

    public DrawableDecorator(Drawable decoratedDrawable) {
        this.decoratedDrawable = decoratedDrawable;
    }

    @Override
    public void draw() {
        decoratedDrawable.draw();
    }
}
