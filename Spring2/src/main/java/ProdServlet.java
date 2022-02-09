import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ProdServlet", urlPatterns = "/prod")
public class ProdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        int id = 1;
        ProdEnum title;
        int cost;
        while (id<11){
            title = ProdEnum.values()[1+(int)(Math.random()*10)];
            cost = 1 + (int)(Math.random()*10000);
            Product product = new Product(id,title,cost);
            writer.println(product);
            id++;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}
