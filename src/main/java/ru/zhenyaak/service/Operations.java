package ru.zhenyaak.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ru.zhenyaak.model.City;

public class Operations{

	private static void printCity(List<City> list) {
		for (City c : list)
			System.out.println(c);
	}

	public static List<City> showCities(List<City> list) {
		printCity(list);
		return list;
	}

	public static List<City> citySort(List<City> list) {
		list.sort(Comparator.comparing((City city) -> city.getName())
				.thenComparing((City city) -> city.getFoundation()));
		printCity(list);
		return list;
	}

	public static List<City> districtSort(List<City> list) {
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
		for (City c : list)
			System.out.println(c);
		return list;
	}
	
	public static int cityWithMaxPopulation(List<City> list) {
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
	
	public static Map<String, Integer> citiesInRegion(List<City> list) {
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
