package Spring.Lesson1.Hospital.Dostors;



import java.time.DayOfWeek;
import java.util.HashMap;


public class Oculist implements Doctor {
    private final String type = "Oculist";
    private final int cabinetNumber = 3;
    private HashMap<DayOfWeek, String> schedule;

    public Oculist(){
        schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY,"9:00-13:00 / 14:00-18:00");
        schedule.put(DayOfWeek.TUESDAY,"9:00-13:00 / 14:00-18:00");
        schedule.put(DayOfWeek.WEDNESDAY,"9:00-13:00 / 14:00-18:00");
        schedule.put(DayOfWeek.THURSDAY,"9:00-13:00 / 14:00-18:00");
        schedule.put(DayOfWeek.FRIDAY,"9:00-13:00 / 14:00-18:00");
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
