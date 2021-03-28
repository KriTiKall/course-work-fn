package data.dao;

import data.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DepartmentDao extends AbstractDao<Department, Long> {

    private final Department empty = new Department();

    public DepartmentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Department read(Long id) {
        return read(id, empty);
    }

    @Override
    public List<Department> getList() {
        return getList(empty.getClass().getName());
    }
}
