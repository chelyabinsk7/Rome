package ru.zhenyaak.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

import ru.zhenyaak.model.City;

public class ReadFile {
	
	private static String slash = File.separator; 
	private static String path = "C:"+slash+"12345"+slash+"RegionStat"+slash+"stat.txt";
	private static String path1 = "stat.txt"; // For Mac OS
	private static File file = new File(path1);
	
	public static List<City> list = new ArrayList<>();
	
    public static List<City> readFile(){
		try {
			Scanner scnForCountNumbers = new Scanner(file);
			int count = 0;
			if (!scnForCountNumbers.hasNextLine()) {
				System.out.println("Файл с городами пуст. Заполните файл и запустите программу заново");
				System.exit(0);
			}
			while (scnForCountNumbers.hasNextLine()) {
			    count++;
				scnForCountNumbers.nextLine();
			}
			scnForCountNumbers.close();
			
			Scanner scnForReadFile = new Scanner(file);
			if (count > 1) {
				while(scnForReadFile.hasNextLine()) {
					String s = scnForReadFile.nextLine();
					String[] s1 = s.split(";");
					list.add(new City(parseInt(s1[0]), s1[1], s1[2], s1[3], parseInt(s1[4]), parseInt(s1[5])));
				}
			}
			else if (count == 1) {
				String s = scnForReadFile.nextLine();
				String[] s1 = s.split(";");
				for (int i = 0; i < s1.length; i = i + 6) {
					list.add(new City(parseInt(s1[i]), s1[i+1], s1[i+2], s1[i+3], parseInt(s1[i+4]), parseInt(s1[i+5])));
				}
			}
			scnForReadFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
    }
}
