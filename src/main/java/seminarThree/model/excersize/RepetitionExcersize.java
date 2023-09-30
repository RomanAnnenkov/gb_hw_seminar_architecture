package seminarThree.model.excersize;

public class RepetitionExcersize extends BaseExcersize {

    private int numberOfRepetitions;
    public RepetitionExcersize(String name, int numberOfRepetitions) {
        super(name);
        this.numberOfRepetitions = numberOfRepetitions;
    }

    public int getRepetitions() {
        return numberOfRepetitions;
    }

    public void setRepetitions(int numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
    }

    @Override
    public void doExcersize() {
        System.out.println("do repeat");
    }
}
