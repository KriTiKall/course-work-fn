package data.dao;

import data.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientDao extends AbstractDao<Client, Long> {

    public ClientDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Client read(Long id) {
        try (final Session session = sessionFactory.openSession()) {
            Client client = session.get(Client.class, id);
            return client != null ? client : new Client();
        }
    }

    @Override
    public List<Client> getList() {
        try (final Session session = sessionFactory.openSession()) {
            return session.getSession().createQuery("from Client").list();
        }
    }
}
