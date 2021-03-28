import controller.DepartmentController
import logic.MainService
import org.hibernate.cfg.Configuration
import view.DepartmentForm
import javax.swing.SwingUtilities


fun main() {
//    val sessionFactory = Configuration().configure().buildSessionFactory()
//
//
//    val form = MainForm()
//    val service = MainService(sessionFactory)
//    val controller = MainController(form, service)

//    sessionFactory.close()

//    val form = MainController()
//    form.initView()
//
//    val form = SignInForm()
//    val controller = SignInController(form)
//
//    controller.initView()
    SwingUtilities.invokeLater {
        val sessionFactory = Configuration().configure().buildSessionFactory()

        val form = DepartmentForm()
        val service = MainService(sessionFactory)
        val con = DepartmentController(form, service)
        con.initView()
    }
}