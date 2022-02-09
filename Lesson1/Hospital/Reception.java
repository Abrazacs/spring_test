package Spring.Lesson1.Hospital;

import Spring.Lesson1.Hospital.Dostors.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class Reception {
    private Archive archive;
    private ManningTable manningTable;

    public void reacts(String doctor, int clientId) {
        for (Integer id: archive.getClientList()) {
            if(id == clientId){
                for (Doctor doc: manningTable.getManningTable()) {
                    if(doc.getType().equals(doctor)){
                        System.out.println("Расписание: " + doc.getSchedule().toString()+"\n");
                        System.out.println("Прием в кабинете: " + doc.getCabinetNumber());
                    }else {
                        System.out.println("У нас нет такого специалиста");
                    }
                }
            } else {
                System.out.println("Вы у нас в первый раз. Прошу на регистрацию");
            }
        }
    }

    @Autowired(required = false)
    @Qualifier("archive")
    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    @Autowired(required = false)
    @Qualifier("manningTable")
    public void setManningTable(ManningTable manningTable) {
        this.manningTable = manningTable;
    }
}
