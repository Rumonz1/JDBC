package DAO;

import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


public class EmployeeDAOImpl implements EmployeeDao{
    private final Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createEmployee(Employee employee) {
        try(PreparedStatement statement = connection.prepareStatement("INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ((?),(?),(?),(?),(?))")) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getByID(int id) {
        Employee employee = new Employee();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee left join city on employee.city_id = city.city_id WHERE id = (?) ")) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity_id(resultSet.getInt("city_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee left join city on employee.city_id = city.city_id")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName =resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender =  resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int city_id = resultSet.getInt("city_id");
                employeeList.add(new Employee(id,firstName,lastName,gender,age,city_id ));
            }

        }
        return employeeList;
    }

    @Override
    public void updateEmployee(int id, String first_name, String last_name, String gender, int age, int city_id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE employee SET first_name=(?),last_name=(?),gender=(?),age=(?),city_id=(?) WHERE id=(?)")) {
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, city_id);
            statement.setInt(6, id);
            statement.executeUpdate();
        }

    }


    @Override
    public void deleteEmployee(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id=(?)")) {
            statement.setInt(1, id);
            statement.executeQuery();
        }

    }
}
