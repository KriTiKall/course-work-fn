package data.dao;

import data.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OrderItemDao extends AbstractDao<OrderItem, Long> {

    public OrderItemDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public OrderItem read(Long id) {
        try (final Session session = sessionFactory.openSession()) {
            OrderItem orderItem = session.get(OrderItem.class, id);
            return orderItem != null ? orderItem : new OrderItem();
        }
    }

    @Override
    public List<OrderItem> getList() {
        try (final Session session = sessionFactory.openSession()) {
            return session.getSession().createQuery("from OrderItem").list();
        }
    }
}
