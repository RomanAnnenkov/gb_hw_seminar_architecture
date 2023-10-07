package seminarSix.patternProxy;

import java.util.Date;

public class ScheduleFromCache implements ISchedule{
    private final ISchedule schedule;
    private String[] cahchedSchedule;
    private int lifetimeInSeconds;
    private long uploadTime;

    public void setLifetimeInSeconds(int lifetimeInSeconds) {
        this.lifetimeInSeconds = lifetimeInSeconds;
    }

    public ScheduleFromCache(ISchedule schedule, int lifetimeInSeconds) {
        this.schedule = schedule;
        this.lifetimeInSeconds = lifetimeInSeconds;
        uploadTime = new Date().getTime();
    }

    @Override
    public String[] getSchedule() {
        boolean isCacheExpired = (new Date().getTime() - uploadTime)/1000 > lifetimeInSeconds;

        if (cahchedSchedule == null || isCacheExpired) {
            cahchedSchedule = schedule.getSchedule();
            uploadTime = new Date().getTime();
        }
        return cahchedSchedule;
    }
}
