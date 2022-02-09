package Spring.Lesson1.Hospital.Dostors;

import java.time.DayOfWeek;
import java.util.HashMap;

public interface Doctor {

  String getType();
  HashMap<DayOfWeek,String> getSchedule();
  int getCabinetNumber();

}
