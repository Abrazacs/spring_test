package Spring.Lesson1.Hospital;

import Spring.Lesson1.Hospital.Dostors.Doctor;
import Spring.Lesson1.Hospital.Dostors.Oculist;
import Spring.Lesson1.Hospital.Dostors.Surgeon;
import Spring.Lesson1.Hospital.Dostors.Therapeutic;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component ("manningTable")
@Getter
public class ManningTable {
    private List<Doctor> manningTable;

    public ManningTable(){
        manningTable = new ArrayList<>();
        manningTable.add(new Oculist());
        manningTable.add(new Surgeon());
        manningTable.add(new Therapeutic());
    }

    public List<Doctor> getManningTable(){
        return manningTable;
    }

}
