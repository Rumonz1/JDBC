package DAO;

import configuration.HibernateSessionFactoryUtil;
import model.City;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public void createCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();){
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();}

    }

    @Override
    public City getByID(int id) {
            return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
        }



    @Override
    public List<City> getAll() throws SQLException {
        List<City> cityList = (List<City>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM City").list();
        return cityList;
    }

    @Override
    public void updateCity(City city) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }

    }

    @Override
    public void deleteCity(City city) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }

    }
}
