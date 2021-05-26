package ru.zhenyaak;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.zhenyaak.model.City;
import ru.zhenyaak.service.Operations;
import ru.zhenyaak.service.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class OperationsTest {

	List<City> startList = new ArrayList<>();
	List<City> sortNameList = new ArrayList<>();

	@Before
	public void createList() {
		startList.add(new City(1, "Екатеринбург", "Свердловская область", "Уральский", 122548, 1933));
		startList.add(new City(2, "Абдулино", "Оренбургская область", "Приволжский", 12278, 1573));
		startList.add(new City(3, "Абдулино", "Оренбургская область", "Приволжский", 12248, 1930));
		startList.add(new City(4, "Челябинск", "Челябинская область", "Уральский", 19248, 1972));
		startList.add(new City(5, "Магнитогорск", "Челябинская область", "Уральский", 122248, 1973));
	}
	
	@Test
	public void showCitiesTest() {
		 Assert.assertFalse(Operations.showCities(startList).isEmpty());
	}

	@Test
	public void citySortTest() {
		sortNameList.add(new City(2, "Абдулино", "Оренбургская область", "Приволжский", 12278, 1573));
		sortNameList.add(new City(3, "Абдулино", "Оренбургская область", "Приволжский", 12248, 1930));
		sortNameList.add(new City(1, "Екатеринбург", "Свердловская область", "Уральский", 122548, 1933));
		sortNameList.add(new City(5, "Магнитогорск", "Челябинская область", "Уральский", 122248, 1973));
		sortNameList.add(new City(4, "Челябинск", "Челябинская область", "Уральский", 19248, 1972));
		Assert.assertEquals(sortNameList, Operations.citySort(startList));
	}

	@Test
	public void cityWithMaxPopulationTest() {
		 Assert.assertEquals(Operations.cityWithMaxPopulation(startList), 122548);
	}

	@Test
	public void citiesInRegionTest() {
		 Assert.assertEquals(Operations.citiesInRegion(startList).size(), 3);
	}
}
