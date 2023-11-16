package com.map;

import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMapDemo {

	public static void main(String[] args) {
		
		// returns the highest value that is lower than current value 2
		System.out.println(Math.floor(2.3));
		// returns the lowest value that is higher then the current value 3
		System.out.println(Math.ceil(2.3)); 
		
		// is always arramnged in the ascending order of the Keys
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(10, "Shalini");
		map.put(9, "Raju");
		map.put(1, "Ajay");
		map.put(2, "Arundhaty");
		map.put(5, "Manas");
		map.put(3, "Akankshya");
		System.out.println(map.put(5, "Prasanna"));
		map.put(6, "Vibhati");
		System.out.println(map);
		map.forEach(new BiConsumer<Integer, String>() {

			@Override
			public void accept(Integer key, String value) {
				// TODO Auto-generated method stub
				System.out.println(key+" : "+value);
			}
			
		});
		
		System.out.println(map.firstEntry());
		System.out.println(map.firstKey());
		System.out.println(map.ceilingEntry(4));
		System.out.println(map.floorEntry(4));
		
		System.out.println(map.headMap(5, true));
		System.out.println(map);
		
		System.out.println(map.higherEntry(10));
		System.out.println(map.higherEntry(7));
		
		System.out.println(map.pollFirstEntry());
		
		System.out.println(map.pollLastEntry());
		System.out.println(map);
		
		System.out.println(map.subMap(2, 6));
		System.out.println(map.subMap(2,false, 6, true));
		
	}

}
