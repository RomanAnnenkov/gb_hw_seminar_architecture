package seminarThree.model.workout;

import seminarThree.model.excersize.BaseExcersize;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<BaseExcersize> excersizeList = new ArrayList<>();

    public List<BaseExcersize> getExcersizeList() {
        return excersizeList;
    }

    public void addExcersize(BaseExcersize excersize) {
        excersizeList.add(excersize);
    }

    public void removeExcersize(int index) {
        excersizeList.remove(index);
    }

    public void doExcersizes() {
        for (BaseExcersize e:excersizeList) {
            System.out.print(e.getName() + " ");
            e.doExcersize();
        }
    }
}
