package Spring.Lesson1.Hospital;

import org.springframework.stereotype.Component;

import java.util.List;

@Component ("archive")
public class Archive {
    private List<Integer> clientList;

    public Archive(){
        for (int i = 0; i < 400; i++) {
            clientList.add(i);
        }
    }

    public List<Integer> getClientList(){
        return clientList;
    }
}
