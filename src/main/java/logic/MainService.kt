package logic

import data.dao.*
import org.hibernate.SessionFactory

class MainService(sessionFactory: SessionFactory) {

    val depDao = DepartmentDao(sessionFactory)
    val warDao = WarehouseDao(sessionFactory)
    val clientDao = ClientDao(sessionFactory)
    val productDao = ProductDao(sessionFactory)
    val orderDao = OrderDao(sessionFactory)
    val itemDao = OrderItemDao(sessionFactory)
}