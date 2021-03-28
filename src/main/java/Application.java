import controller.MainController;
import logic.MainService;
import lombok.val;
import org.hibernate.cfg.Configuration;
import view.MainForm;

public class Application {
    public static void main(String[] args) {
        val sessionFactory = new Configuration().configure().buildSessionFactory();


        val form = new MainForm();
        val service = new MainService(sessionFactory);
        val controller = new MainController(form, service);

        sessionFactory.close();
    }
}
