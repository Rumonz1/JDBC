package DAO;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
     void createEmployee (Employee employee);
     Employee getByID (int id);
     List<Employee> getAll() throws SQLException;

     void updateEmployee(Employee employee) throws SQLException;

     void deleteEmployee(Employee employee) throws SQLException;
}
