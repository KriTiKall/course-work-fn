package data.dao;

import data.entity.User;
import data.entity.Warehouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class WarehouseDao extends AbstractDao<Warehouse, Long>{

    public WarehouseDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Warehouse read(Long id) {
        try (final Session session = sessionFactory.openSession()) {
            Warehouse warehouse = session.get(Warehouse.class, id);
            return warehouse != null ? warehouse : new Warehouse();
        }
    }

    @Override
    public List<Warehouse> getList() {
        try (final Session session = sessionFactory.openSession()) {
            return session.getSession().createQuery("from Warehouse").list();
        }
    }
}

