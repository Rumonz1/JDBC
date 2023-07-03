import DAO.CityDAO;
import DAO.CityDAOImpl;
import DAO.EmployeeDAOImpl;
import DAO.EmployeeDao;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException{
        EmployeeDao employeeDao = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

//        Employee employee1 = new Employee("Georgy", "Liskin", "Male", 41, new City(1,"Грозный"));
//        Employee employee2 = new Employee("Yulya", "Emanova", "Female", 30, new City(2));
//        employeeDao.createEmployee(employee2);
//        System.out.println(employeeDao.getByID(16));
//        List<Employee> list = employeeDao.getAll();
//        for (Employee employee : list) {
//            System.out.println(employee);
//        }
//        employeeDao.updateEmployee(new Employee(25, "Loli","Jojoja","Female",20, new City(2)));
//        employeeDao.deleteEmployee(employeeDao.getByID(16));



//        City city1 = new City("Bashkartostan");
//        cityDAO.createCity(city1);
//        cityDAO.updateCity(new City(4, "Башкартостан"));
//        cityDAO.deleteCity(new City(4, "Башкартостан"));
        List<City> cityList = cityDAO.getAll();
        for (City city : cityList) {
            System.out.println(city);
        }



        }

    }
