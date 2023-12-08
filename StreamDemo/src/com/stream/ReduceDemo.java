package com.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceDemo {

	public static void main(String[] args) {
		
		List<Integer> nos = new ArrayList<Integer>();
		nos.add(10);
		nos.add(4);
		nos.add(2);
		nos.add(3);
		nos.add(6);
		nos.add(5);
		nos.add(3);
		nos.add(6);
		
		int sum = 0;
		for(int n: nos)
			sum+=n;
		System.out.println(sum);
		
		System.out.println(sum/nos.size());
		
		
		int sum1 = nos.get(0);
		for(int i=1;i<nos.size();i++)
			sum1+=nos.get(i);

		// taking the list and reducing it to a single value
		
		new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		System.out.println(nos);
//		int res = nos.stream().reduce((n1, n2) -> {
//			System.out.println("n1 "+ n1+" n2 "+n2);
//			return n1+n2;
//		}).get();
//		System.out.println(res);
		
		int res1 = nos.stream().reduce(0,(sum2, n2) -> {
			System.out.println("sum2 "+ sum2+" n2 "+n2);
			return sum2+n2;
		});
		System.out.println(res1);
		
		List<String> names = Arrays.asList("Shalini","Ajay","Prince","Arundhaty");
		System.out.println(names.stream()
				.reduce("", (result, name ) -> result.concat(name+",")));
		
		List<City> cities = new ArrayList<City>();
		cities.add(new City("Mumbai", 25, LocalDate.now()));
		cities.add(new City("Pune", 27, LocalDate.now()));
		cities.add(new City("Delhi", 5, LocalDate.now()));
		cities.add(new City("Chennai", 30, LocalDate.now()));
		cities.add(new City("Hyderabad", 28, LocalDate.now()));
		cities.add(new City("Indore", 22, LocalDate.now()));
		
		double tempsum = cities.stream().map(city -> city.getTemp()).reduce((t1, t2)-> t1+2).get();
		System.out.println(tempsum/cities.size());
	}

}
