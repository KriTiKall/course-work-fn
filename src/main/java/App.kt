import data.dao.ClientDao
import data.entity.Client
import org.hibernate.cfg.Configuration


fun main() {
    val sessionFactory = Configuration().configure().buildSessionFactory()

    sessionFactory.use {
        val dao = ClientDao(sessionFactory)
        val entity = Client()
        with(entity) {
            name = "Maxim"
            mail = "asdasd@mail.ru"
            phone = "89523485967"
        }

        dao.create(entity)

//        dao.list.forEach(::print)
    }
}