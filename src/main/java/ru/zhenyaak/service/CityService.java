package ru.zhenyaak.service;

import ru.zhenyaak.DAO.CityDAO;
import ru.zhenyaak.model.City;
import java.util.List;
import java.util.Map;

public class CityService {

    private static void printCitiesDB(List<City> list) {
        for (City city : list)
            System.out.println(city);
    }

    public static void showCitiesDB(){
        printCitiesDB(CityDAO.showCitiesDB());
    }

    public static void citiesSortByNameDB() {
        printCitiesDB(CityDAO.citiesSortByNameDB());
    }

    public static void citiesSortByDistrictDB() {
        printCitiesDB(CityDAO.citiesSortByDistrictDB());
    }

    public static void cityWithMaxPopulationDB() {
        System.out.println(CityDAO.cityWithMaxPopulationDB().getId() + " " +
                CityDAO.cityWithMaxPopulationDB().getPopulation());
    }

    public static void citiesInRegionDB() {
        for(Map.Entry regionAndCity : CityDAO.citiesInRegionDB().entrySet())
            System.out.println(regionAndCity.getKey() + " - " + regionAndCity.getValue());
    }
}
