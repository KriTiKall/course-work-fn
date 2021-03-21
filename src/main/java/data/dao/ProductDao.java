package data.dao;

import data.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductDao extends AbstractDao<Product, Long> {

    public ProductDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Product read(Long id) {
        try (final Session session = sessionFactory.openSession()) {
            Product product = session.get(Product.class, id);
            return product != null ? product : new Product();
        }
    }

    @Override
    public List<Product> getList() {
        try (final Session session = sessionFactory.openSession()) {
            return session.getSession().createQuery("from Product").list();
        }
    }
}
