package data.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class DepartmentDaoTest {

    @Test
    @DisplayName("Bed res")
    void read() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        DepartmentDao dao = new DepartmentDao(sessionFactory);
        Assertions.assertEquals(dao.read(1l).getId(), 1l);
    }
}