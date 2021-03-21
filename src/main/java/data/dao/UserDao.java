package data.dao;

import data.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDao extends AbstractDao<User, String> {

    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User read(String login) {
        try (final Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, login);
            return user != null ? user : new User();
        }
    }

    @Override
    public List<User> getList() {
        try (final Session session = sessionFactory.openSession()) {
            return session.getSession().createQuery("from User").list();
        }
    }
}
