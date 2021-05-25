package ru.zhenyaak.service;

import java.util.Scanner;

public class Menu {
	
	public static void showMenu() {
		ReadFile.readFile();
    	Scanner abc = new Scanner(System.in);
    	int operation = abc.nextInt();
    	switch (operation) {
	        case 1:  Operations.showCity();
	                 break;
	        case 2:  Operations.citySort();
	                 break;
	        case 3:  Operations.districtSort();
	                 break;
	        case 4:  Operations.maxPopulation();
	                 break;
	        case 5: Operations.cityRegions();
	                 break;	
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
