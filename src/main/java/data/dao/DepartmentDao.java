package data.dao;

import data.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DepartmentDao extends AbstractDao<Department, Long> {

    public DepartmentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Department read(Long id) {
        try (final Session session = sessionFactory.openSession()) {
            Department department = session.get(Department.class, id);
            return department != null ? department : new Department();
        }
    }

    @Override
    public List<Department> getList() {
        try (final Session session = sessionFactory.openSession()) {
            return session.getSession().createQuery("from Department ").list();
        }
    }
}
