package Spring.Lesson1;



import Spring.Lesson1.Hospital.Reception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Client {

    private final String doctor = "Therapeutic";
    private final int clientId = 123;

    @Autowired
    @Qualifier("reception")
    public void interactWithReception(Reception reception){
        reception.reacts(doctor, clientId);
    }
}
