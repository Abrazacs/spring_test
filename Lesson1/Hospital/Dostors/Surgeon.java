package Spring.Lesson1.Hospital.Dostors;

import java.time.DayOfWeek;
import java.util.HashMap;



public class Surgeon implements Doctor {
    private String type = "Surgeon";
    private final int cabinetNumber = 2;
    private HashMap<DayOfWeek, String> schedule;

    public Surgeon(){
        schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY,"9:00-13:00 / 14:00-18:00");
        schedule.put(DayOfWeek.TUESDAY,"9:00-13:00 / 14:00-18:00");
        schedule.put(DayOfWeek.WEDNESDAY,"8:00-12:00 / 13:00-17:00");
        schedule.put(DayOfWeek.THURSDAY,"8:00-12:00 / 13:00-17:00");
        schedule.put(DayOfWeek.FRIDAY,"8:30-13:00 / 14:00-17:30");
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
