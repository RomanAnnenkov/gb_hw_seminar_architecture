package seminarThree.model.excersize;

public abstract class BaseExcersize {
    private String name;

    public BaseExcersize(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doExcersize() {
        //do
    }

}
