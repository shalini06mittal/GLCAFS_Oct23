package com.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) throws IOException {
		
		Stream<String> stream = Stream.empty();
		
		stream.forEach(d-> System.out.println("data "+d));
		
		List<String> l = new ArrayList<String>();
		// l => 
		stream = l.stream();
		stream.forEach(d-> System.out.println("data "+d));
		
		
		int [] nos = new int[] {1,2,3,4,5};
		IntStream st = Arrays.stream(nos);
		//stream = st.distinct();
		Arrays.stream(Arrays.asList("","","").toArray());
	
		// builder
		Stream<String> builder = Stream.<String>builder().add("Apples").add("Oranges").build();
		
		//System.out.println(builder.count());
		builder.forEach(fruit-> System.out.println(fruit));

		// generate()
		Stream<Double> temps = Stream.generate(() -> {
			double no = new Random().nextDouble()*10;
			System.out.println(no+" generated");
			return no;
		}).limit(10) ;
//		temps.forEach(temp->{
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(temp);
//		});
		// iterate()
		Stream<Integer> st1 = Stream.iterate(40, n->n+2).limit(10);
		//st1.forEach(data-> System.out.println(data));
		
		Path path = Paths.get("data.txt");
//		try (Stream<String> streamOfLines = Files.lines(path)) {
//			streamOfLines.forEach(line->System.out.println(line));
//		}
		
		//of
		Optional<Integer> value = Stream.of(1,2,3,4,5,6,7,8,9,10)
			.skip(1).findAny();
		System.out.println(value.get());
		
		
		Optional<String> color = Stream.of("Red","black","Green","black")
				.filter(c-> {
					System.out.println("in filter " +c);
					return c.equals("black");
				})
				.findFirst();
		if(color.isPresent())
			System.out.println(color.get().toUpperCase());
		else {
			System.out.println("not present");
		}
		
		
		StreamDemo ob = new StreamDemo();
		// 1 lakh records
		List<String> items = Arrays.asList("laptop","mouse","speaker");
		
		long count = items.stream().map(element ->{
			System.out.println("mapping.. "+element);
			ob.called();
			return element.substring(2);
		})
		.skip(2).count();
		System.out.println(count);
		System.out.println(ob.counter);
		System.out.println();
		
		items.stream().map(element ->{
			System.out.println("mapping.. "+element);
			ob.called();
			return element.substring(2);
		})
		.skip(2).forEach(item-> System.out.println(item));
		
		System.out.println();
		items.stream()
		.skip(2)
		.map(element ->{
			System.out.println("mapping.. "+element);
			ob.called();
			return element.substring(2);
		})
		.forEach(item-> System.out.println(item));
		
		int numbers[]={12,34,45,1,9,56,8};
		System.out.println(Arrays.stream(numbers).filter(no->no%2!=0).map(n->n*n).max().getAsInt());
//		int
//		maxSqr=Arrays.stream(numbers).filter(no->no%2!=0).map(n->n*n).max().getAsInt();System.out.println("Squareofmaxoddnumber:"+maxSqr);}}—---------------------------------------------------------—----------------------------------------------------------------

	}
	
	long counter;
	
	void called() {
		System.out.println("called");
		counter++;
	}
	

}
