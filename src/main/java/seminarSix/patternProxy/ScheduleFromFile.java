package seminarSix.patternProxy;

public class ScheduleFromFile implements ISchedule {
    @Override
    public String[] getSchedule() {
        return new String[]{"test01,10-00","test02,11-00","test03,12-00"};
    }

}
