package ru.zhenyaak.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ru.zhenyaak.model.City;

public class Operations{

	private static void printCitiesFile(List<City> list) {
		for (City city : list)
			System.out.println(city);
	}

	public static List<City> showCitiesFile(List<City> list) {
		printCitiesFile(list);
		return list;
	}

	public static List<City> citiesSortByNameFile(List<City> list) {
		list.sort(Comparator.comparing((City city) -> city.getName())
				.thenComparing((City city) -> city.getFoundation()));
		printCitiesFile(list);
		return list;
	}

	public static List<City> citiesSortByDistrictFile(List<City> list) {
		list.sort(Comparator.comparing((City city) -> city.getDistrict())
				.thenComparing((City city) -> city.getName()));
//		ReadFile.list.sort((o1, o2) -> {
//			if (o1.getDistrict().compareTo(o2.getDistrict()) != 0)
//				return o1.getDistrict().compareTo(o2.getDistrict());
//			return o1.getName().compareTo(o2.getName());
//		});
//		Collections.sort(ReadFile.list, new Comparator<City>() {
//			@Override
//			public int compare(City o1, City o2) {
//              if (o1.getDistrict().compareTo(o2.getDistrict()) != 0)
//              	  return o1.getDistrict().compareTo(o2.getDistrict());
//              return o1.getName().compareTo(o2.getName());
//			}
//		});
		printCitiesFile(list);
		return list;
	}
	
	public static int cityWithMaxPopulationFile(List<City> list) {
		int[] arr = new int[list.size()];
		int i = 0;
		for (City city : list) {
			arr[i] = city.getPopulation();
			i++;
		}
		int maxPopulation = arr[0];
		int maxIndex = 0;
		for (i = 1; i < arr.length; i++) {
			if (arr[i] > maxPopulation) {
				maxPopulation = arr[i];
				maxIndex = i;
			}
		}
		System.out.println("[" + maxIndex + "]" + " " + maxPopulation);
		return maxPopulation;
	}
	
	public static Map<String, Integer> citiesInRegionFile(List<City> list) {
		Map<String, Integer> map = new TreeMap<>(); 
		for (City city : list) {
			if (map.containsKey(city.getRegion()))
				map.put(city.getRegion(), map.get(city.getRegion()) + 1);
			else 
				map.put(city.getRegion(), 1);
		}
		for(Map.Entry regionAndCity : map.entrySet()) {
			System.out.println(regionAndCity.getKey() + " - " + regionAndCity.getValue());
		}
		return map;
	}
	
}
