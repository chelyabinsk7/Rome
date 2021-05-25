package ru.zhenyaak.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ru.zhenyaak.model.City;

public class Operations{
	
	public static List<City> showCity() {
		for (City c : ReadFile.list)
			System.out.println(c);
		return ReadFile.list;
	}
	
	public static List<City> citySort() {
		Collections.sort(ReadFile.list); 
		for (City c : ReadFile.list)
			System.out.println(c);
		return ReadFile.list;
	}
	
	public static List<City> districtSort() {
		Collections.sort(ReadFile.list, new Comparator<City>() {

			@Override
			public int compare(City o1, City o2) {
				int res = o1.getDistrict().compareTo(o2.getDistrict());
                if (res != 0)
                    return res;
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (City c : ReadFile.list)
			System.out.println(c);
		return ReadFile.list;
	}
	
	public static int maxPopulation() {
		int[] arr = new int[ReadFile.list.size()];
		int i = 0;
		for (City c : ReadFile.list) {
			arr[i] = c.getPopulation();
			i++;
		}
		int max = arr[0];
		int maxIndex = 0;
		for (i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		System.out.println("[" + maxIndex + "]" + " " + max);
		return maxIndex;
	}
	
	public static Map<String, Integer> cityRegions() {
		Map<String, Integer> map = new TreeMap<>(); 
		for (City c : ReadFile.list) {
			if (map.containsKey(c.getRegion()))
				map.put(c.getRegion(), map.get(c.getRegion()) + 1);
			else 
				map.put(c.getRegion(), 1);
		}
		for(Map.Entry entry1 : map.entrySet()) {
			System.out.println(entry1.getKey() + " - " + entry1.getValue());
		}
		return map;
	}
	
}
