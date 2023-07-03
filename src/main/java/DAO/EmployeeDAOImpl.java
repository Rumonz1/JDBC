package DAO;

import configuration.HibernateSessionFactoryUtil;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


public class EmployeeDAOImpl implements EmployeeDao{
//    private final Connection connection;

//    public EmployeeDAOImpl(Connection connection) {
//        this.connection = connection;
//    }
//    public EmployeeDAOImpl() {
//
//    }

    @Override
    public void createEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getByID(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employees = (List<Employee>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Employee ").list();
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }

    }


    @Override
    public void deleteEmployee(Employee employee) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }


    }
}
