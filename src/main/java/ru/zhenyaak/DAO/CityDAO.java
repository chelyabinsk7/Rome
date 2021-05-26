package ru.zhenyaak.DAO;

import ru.zhenyaak.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    private static final String URL = "jdbc:h2:/Users/u19215200/Documents/Intel/" +
            "RegionStatIdea2/db/Cities;MV_STORE=false";
    private static final String USERNAME = "Eugeny";
    private static final String PASSWORD = "12345678";
    private static Connection connection;
    public static List<City> listCityDAO = new ArrayList<>();

    static{
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("____SUCCESS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<City> getCityFromDB(){
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
            System.out.println(listCityDAO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCityDAO;
    }
}
