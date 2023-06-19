package DAO;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
     void createEmployee (Employee employee);
     Employee getByID (int id);
     List<Employee> getAll() throws SQLException;

     void updateEmployee(int id, String first_name, String last_name, String gender, int age, int city_id) throws SQLException;

     void deleteEmployee(int id) throws SQLException;
}
