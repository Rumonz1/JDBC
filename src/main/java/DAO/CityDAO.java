package DAO;

import model.City;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO {
    void createCity (City city);
    City getByID (int id);
    List<City> getAll() throws SQLException;

    void updateCity(City city) throws SQLException;

    void deleteCity(City city) throws SQLException;
}
