package seminarThree.model.excersize;

public class TimeExcersize extends BaseExcersize {

    private int seconds;

    public int getInterval() {
        return seconds;
    }

    public void setInterval(int seconds) {
        this.seconds = seconds;
    }

    public TimeExcersize(String name, int seconds) {
        super(name);
        this.seconds = seconds;
    }

    @Override
    public void doExcersize() {
        System.out.println("do on time");
    }

}
