import controller.MainController
import logic.MainService
import org.hibernate.cfg.Configuration
import view.MainForm
import view.WarehouseForm


fun main() {
    val sessionFactory = Configuration().configure().buildSessionFactory()


    val form = MainForm()
    val service = MainService(sessionFactory)
    val controller = MainController(form, service)

    sessionFactory.close()

//    val form = WarehouseForm()
//    form.createUI()
}