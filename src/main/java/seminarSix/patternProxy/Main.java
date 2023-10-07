package seminarSix.patternProxy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ISchedule schedule = new ScheduleFromFile();
        ISchedule cachedSchedule = new ScheduleFromCache(schedule, 300);

        String[] scheduleForPrint = cachedSchedule.getSchedule();

        System.out.println(Arrays.toString(scheduleForPrint));

    }
}
