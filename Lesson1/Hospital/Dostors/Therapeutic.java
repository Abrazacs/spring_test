package Spring.Lesson1.Hospital.Dostors;

import java.time.DayOfWeek;
import java.util.HashMap;


public class Therapeutic implements Doctor {
    private final String type = "Therapeutic";
    private final int cabinetNumber = 1;
    private HashMap<DayOfWeek, String> schedule;

    public Therapeutic(){
        schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY,"8:00-12:00 / 13:00-17:00");
        schedule.put(DayOfWeek.TUESDAY,"8:00-12:00 / 13:00-17:00");
        schedule.put(DayOfWeek.WEDNESDAY,"8:00-12:00 / 13:00-17:00");
        schedule.put(DayOfWeek.THURSDAY,"8:00-12:00 / 13:00-17:00");
        schedule.put(DayOfWeek.FRIDAY,"8:00-12:00 / 13:00-17:00");
        schedule.put(DayOfWeek.SATURDAY,"Weekend! Please get back during Mon-Fri");
        schedule.put(DayOfWeek.SUNDAY,"Weekend! Please get back during Mon-Fri");
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public HashMap<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    @Override
    public int getCabinetNumber() {
        return cabinetNumber;
    }
}
