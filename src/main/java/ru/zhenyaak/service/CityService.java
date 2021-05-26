package ru.zhenyaak.service;

import ru.zhenyaak.DAO.CityDAO;
import ru.zhenyaak.model.City;

import java.util.List;

public class CityService {
    public static List<City> getCityFromDB(){
        return CityDAO.getCityFromDB();
    }
}
