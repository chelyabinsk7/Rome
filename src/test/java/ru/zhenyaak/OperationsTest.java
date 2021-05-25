package ru.zhenyaak;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.zhenyaak.model.City;
import ru.zhenyaak.service.Operations;
import ru.zhenyaak.service.ReadFile;

public class OperationsTest {
	
	@Before
	public void readFileTest() {
		ReadFile.readFile();
	}
	
	@Test
	public void showCityTest() {
		 Assert.assertFalse(Operations.showCity().isEmpty());
	}
	
	@Test
	public void citySortTest() {
		City city1 = new City(1, "Москва", "1", "1", 1, 1);
		City city2 = new City(1, "Анадырь", "1", "1", 1, 1);
		Assert.assertTrue(city1.compareTo(city2) > 0);
	}
	
	
	@Test
	public void maxPopulationTest() {
		 Assert.assertEquals(Operations.maxPopulation(), 12);
	}
	
	@Test
	public void cityRegionsTest() {
		 Assert.assertEquals(Operations.cityRegions().size(), 10);
	}
}
