package ru.zhenyaak.service;

import ru.zhenyaak.model.City;

import java.util.List;
import java.util.Scanner;

public class Menu {

	public static List<City> list = ReadFile.readFile();

	public static void showMenu() {
    	Scanner abc = new Scanner(System.in);
    	int operation = abc.nextInt();
    	switch (operation) {
	        case 1:  Operations.showCity(list);
	                 showMenu();
	        case 2:  Operations.citySort(list);
				     showMenu();
	        case 3:  Operations.districtSort(list);
				     showMenu();
	        case 4:  Operations.maxPopulation(list);
				     showMenu();
	        case 5:  Operations.cityRegions(list);
				     showMenu();
	        default: System.out.println("Выберите существующий пункт меню");
	        		 showMenu();
    	}
	}

	public static void startMenu() {
		System.out.println("Выберите действие и нажмите Enter");
		System.out.println("1. Вывести список объектов City в консоль");
		System.out.println("2. Сортировка по названию городов в алфавитном порядке");
		System.out.println("3. Сортировка по округу и названию города");
		System.out.println("4. Преобразовать список городов в массив и показать "
				+ "индекс элемента с наибольшим населением и само значение");
		System.out.println("5. Количество городов в регионе");
	}
}
