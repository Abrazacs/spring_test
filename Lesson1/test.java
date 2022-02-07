package Spring.Lesson1;

import Spring.Lesson1.Hospital.Reception;


import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class test {

    public static void main(String[] args) {
        Client client = new Client();
        Reception reception = new Reception();
        client.interactWithReception(reception);
    }

}
