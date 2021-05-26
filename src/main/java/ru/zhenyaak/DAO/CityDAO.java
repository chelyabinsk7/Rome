package ru.zhenyaak.DAO;

import ru.zhenyaak.model.City;
import java.sql.*;
import java.util.*;

public class CityDAO {
    private static final String URL = "jdbc:h2:/Users/u19215200/Documents/Intel/" +
            "RegionStatIdea2/db/Cities;MV_STORE=false";
    private static final String USERNAME = "Eugeny";
    private static final String PASSWORD = "12345678";
    private static Connection connection;

    static{
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("DB connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No connection to DB");
        }
    }

    public static List<City> showCitiesDB(){
        List<City> listCityDAO = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cities");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
                listCityDAO.add(new City(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("region"),
                        rs.getString("district"),
                        rs.getInt("population"),
                        rs.getInt("foundation")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCityDAO;
    }

    public static List<City> citiesSortByNameDB(){
        List<City> listCityDAO = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM cities ORDER BY name, foundation");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
                listCityDAO.add(new City(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("region"),
                        rs.getString("district"),
                        rs.getInt("population"),
                        rs.getInt("foundation")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCityDAO;
    }

    public static List<City> citiesSortByDistrictDB() {
        List<City> listCityDAO = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM cities ORDER BY district, name");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
                listCityDAO.add(new City(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("region"),
                        rs.getString("district"),
                        rs.getInt("population"),
                        rs.getInt("foundation")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCityDAO;
    }

    public static City cityWithMaxPopulationDB() {
        City city = new City();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT id, population FROM cities WHERE population = (SELECT MAX(population) FROM cities) ");
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                city.setId(rs.getInt(1));
                city.setPopulation(rs.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    public static Map<String, Integer> citiesInRegionDB() {
        Map<String, Integer> map = new TreeMap<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT region, count(*) FROM cities GROUP BY region ");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
                map.put(rs.getString(1), rs.getInt(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
