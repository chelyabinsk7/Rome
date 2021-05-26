package ru.zhenyaak.service;

import ru.zhenyaak.model.City;
import ru.zhenyaak.DAO.CityDAO;

import java.util.List;
import java.util.Scanner;

public class Menu {

	public static List<City> listFile = ReadFile.readFile();
	public static List<City> listDB = CityService.getCityFromDB();

	public static int globalMenu() {
    	Scanner abc = new Scanner(System.in);
    	int location = abc.nextInt();
    	switch (location) {
	        case 1:  showLocalMenu();
	        		 localMenu(location);
			case 2:  showLocalMenu();
				     localMenu(location);
	        default: System.out.println("Выберите 1 или 2");
	        		 globalMenu();
    	}
    	return location;
	}

	public static void localMenu(int location) {
		Scanner abc = new Scanner(System.in);
		int operation = abc.nextInt();
		if (location == 1){
			switch (operation) {
				case 1:  Operations.showCities(listFile);
					     localMenu(location);
				case 2:  Operations.citySort(listFile);
					     localMenu(location);
				case 3:  Operations.districtSort(listFile);
					     localMenu(location);
				case 4:  Operations.cityWithMaxPopulation(listFile);
					     localMenu(location);
				case 5:  Operations.citiesInRegion(listFile);
					     localMenu(location);
				default: System.out.println("Выберите существующий пункт меню");
					     localMenu(location);
			}
		}
		else if (location == 2){
			switch (operation) {
				case 1:  Operations.showCities(listDB);
					     localMenu(location);
				case 2:  Operations.citySort(listDB);
					     localMenu(location);
				case 3:  Operations.districtSort(listDB);
					     localMenu(location);
				case 4:  Operations.cityWithMaxPopulation(listDB);
					     localMenu(location);
				case 5:  Operations.citiesInRegion(listDB);
					     localMenu(location);
				default: System.out.println("Выберите существующий пункт меню");
					     localMenu(location);
			}
		}

	}

	public static void showLocalMenu() {
		System.out.println("Выберите действие и нажмите Enter");
		System.out.println("1. Вывести список объектов City в консоль");
		System.out.println("2. Сортировка по названию городов в алфавитном порядке");
		System.out.println("3. Сортировка по округу и названию города");
		System.out.println("4. Преобразовать список городов в массив и показать "
				+ "индекс элемента с наибольшим населением и само значение");
		System.out.println("5. Количество городов в регионе");
	}

	public static void showGlobalMenu() {
		System.out.println("Где лежат данные?");
		System.out.println("1. Текстовый файл");
		System.out.println("2. БД");
	}
}
