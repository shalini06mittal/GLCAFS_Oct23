package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class MapDemo {

	public static void main(String[] args) {
		/*
		 * Acc no : 6734562819
		 * Phone :  9982131123
		 * 
		 * Key - value pair
		 * Map / Dictionary / Properties
		 * 
		 * unordered and unsorted
		 * Map(I)
		 * HashMap(C), LinkedHashMap(C) implements Map
		 * SortedMap(I) extends Map
		 * TreeMap(C) implements SortedMap
		 */
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		System.out.println(map.put("K1", 1));
		map.put("K2", 2);
		map.put("K5", 3);
		System.out.println(map.put("K1", 4));
		map.put("K3", 5);
		map.put("K6", 6);
		
		System.out.println(map);
		System.out.println(map.putIfAbsent("K10", 10));
		System.out.println(map.putIfAbsent("K1", 100));
		System.out.println(map);
		System.out.println(map.containsKey("K2"));
		System.out.println(map.containsKey("K21"));
		System.out.println(map.remove("K6"));
		System.out.println(map.remove("K1", 4));
		System.out.println(map);
		System.out.println(map.replace("K10", 10, 20));
		System.out.println(map.replace("K2", 10, 20));
		System.out.println(map);
		System.out.println(map.get("K3"));
		System.out.println(map.size());
		System.out.println(map.getOrDefault("K1", 0));
		System.out.println(map.getOrDefault("K10", 0));
		System.out.println(map);
		System.out.println(map.get("K1"));
		
		map.compute("K2", new BiFunction<String, Integer, Integer>() {

			@Override
			public Integer apply(String key, Integer value) {
				// TODO Auto-generated method stub
				System.out.println(key+" "+value);
				if(value == null)
				{
					return value;
				}
				return value * value;
			}
		});
		map.compute("K1", new BiFunction<String, Integer, Integer>() {

			@Override
			public Integer apply(String key, Integer value) {
				// TODO Auto-generated method stub
				System.out.println(key+" "+value);
				if(value == null)
				{
					return 10;
				}
				return value * value;
			}
		});
		
		System.out.println(map);
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.entrySet());
		
		for(Entry<String,Integer> entry:map.entrySet())
		{
			System.out.println(entry.getKey()+ " "+entry.getValue());
		}
//		Map<String, String> data = new HashMap<String, String>();
//		System.out.println(data.getOrDefault("Shalini","-----"));
		/**
		 * Create a list to store names of employees. The names can be repeated.
		 * For ex: Shalini, Ajay, Shalini, Raju, Sara, Ajay, Ajay, Supriya, Sara, Shalini
		 * Iterate over the list and store the name as key in the map and
		 * value be the number of times name exist.
		 * Output : {Shalini= 3, Ajay=3, Raju=1, Sara=2, Supriya=1}
		 */
		
		List<String> names = new ArrayList<String>();
		names.add("Shalini");
		names.add("Ajay");
		names.add("Shalini");
		names.add("Raju");
		names.add("Sara");
		names.add("Ajay");
		names.add("Ajay");
		names.add("Supriya");
		names.add("Sara");
		names.add("Shalini");
		
	}

}
