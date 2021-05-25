package ru.zhenyaak.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ru.zhenyaak.model.City;

public class ReadFile {
	
	private static String slash = File.separator; 
	private static String path = "C:"+slash+"12345"+slash+"RegionStat"+slash+"stat.txt";
	private static String path1 = "stat.txt"; // For Mac OS
	private static File file = new File(path1);
	
	public static List<City> list = new ArrayList<>();
	
    public static void readFile(){
		try {
			Scanner scn0 = new Scanner(file);
			int count = 0;
			if (!scn0.hasNextLine()) {
				System.out.println("Файл с городами пуст. Заполните файл и запустите программу заново");
				System.exit(0);
			}
			while (scn0.hasNextLine()) {
			    count++;
			    scn0.nextLine();
			}
			scn0.close();
			
			Scanner scn = new Scanner(file);
			if (count > 1) {
				while(scn.hasNextLine()) {
					String s = scn.nextLine();
					String[] s1 = s.split(";");
					list.add(new City(Integer.parseInt(s1[0]), s1[1], s1[2], s1[3], Integer.parseInt(s1[4]), Integer.parseInt(s1[5])));
				}
			}
			else if (count == 1) {
				String s = scn.nextLine();
				String[] s1 = s.split(";");
				for (int i = 0; i < s1.length; i = i + 6) {
					list.add(new City(Integer.parseInt(s1[i]), s1[i+1], s1[i+2], s1[i+3], Integer.parseInt(s1[i+4]), Integer.parseInt(s1[i+5])));
				}
			}
			scn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
