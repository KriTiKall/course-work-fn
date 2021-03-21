package data.dao;

import data.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OrderDao extends AbstractDao<Order, Long> {

    public OrderDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Order read(Long id) {
        try (final Session session = sessionFactory.openSession()) {
            Order order = session.get(Order.class, id);
            return order != null ? order : new Order();
        }
    }

    @Override
    public List<Order> getList() {
        try (final Session session = sessionFactory.openSession()) {
            return session.getSession().createQuery("from Order").list();
        }
    }
}
