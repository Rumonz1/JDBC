import DAO.EmployeeDAOImpl;
import DAO.EmployeeDao;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException{
        final String user = "postgres";
        final String password = "predator777";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password)){
            EmployeeDao employeeDao = new EmployeeDAOImpl(connection);
//            Employee employee1 = new Employee("Mikel", "Jordan", "Male",51, 2);
//
//            employeeDao.createEmployee(employee1);
//            employeeDao.deleteEmployee(13);
            employeeDao.updateEmployee(14, "Win", "Pu", "Female", 512, 1);
            List<Employee> list = new ArrayList<>(employeeDao.getAll());
//////
            for (Employee employee : list) {
                System.out.println(employee);
            }
        }

//             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee left join city on employee.city_id = city.city_id WHERE id = (?) ")) {
//            statement.setInt(1, 1);
//            final ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                String firstNameOfEmployee = "Имя: "+ resultSet.getString("first_name");
//                String lastNameOfEmployee = "Фамилия: "+ resultSet.getString("last_name");
//                String genderOfEmployee = "Пол: "+ resultSet.getString("gender");
//                int ageOfEmployee = resultSet.getInt("age");
//                String cityOfEmployee = "Город: "+ resultSet.getString("city_name");
//
//
//                System.out.println(firstNameOfEmployee);
//                System.out.println(lastNameOfEmployee);
//                System.out.println(genderOfEmployee);
//                System.out.println(ageOfEmployee);
//                System.out.println(cityOfEmployee);
//            }



        }

    }
