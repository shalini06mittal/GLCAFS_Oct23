package com.date;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateDemo {

	public static void main(String[] args) throws FileNotFoundException {
		
		Date date = new Date();
		System.out.println(date.toInstant().now());
		
		long start = System.currentTimeMillis();
		
		System.out.println("Before "+start);
		long sum  =0;
		for(int i=1;i<=120000;i++)
			sum+=i;
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println("After "+end);
		System.out.println("total "+ (end-start));
		
		//Duration.ofSeconds(5);
		System.out.println();
		start = System.currentTimeMillis();
		System.out.println("Before "+start);
		long res = 120000*(120000+1)/2;
		System.out.println(res);
		end = System.currentTimeMillis();
		System.out.println("After "+end);
		System.out.println("total "+ (end-start));
		
		System.out.println("LOCAL DATE TIME API");
		LocalDate cdate = LocalDate.now();
		System.out.println(cdate);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		

//		LocalDate firstday_2022 = LocalDate.of(2022, Month.FEBRUARY	, 31);
//		System.out.println(firstday_2022);
		
//		for (String zoneid: ZoneId.getAvailableZoneIds())
//		{
//			System.out.println(zoneid);
//		}
		LocalTime datewithzone = LocalTime.now(ZoneId.of("US/Pacific"));
		System.out.println(datewithzone);
		
		// epoch date? base date : 1/1/1970
		LocalDate dateFrombase = LocalDate.ofEpochDay(100);
		System.out.println(dateFrombase);
		
		LocalDate day202023 = LocalDate.ofYearDay(2023, 65);
		System.out.println(day202023);
		
		LocalDate date1 = LocalDate.of(2023, 12, 23);
		System.out.println(date1.getDayOfMonth());
		System.out.println(date1.getDayOfWeek());
		
		LocalDate bdate = LocalDate.of(2000, 10, 5);
		LocalDate today = LocalDate.now();
		
		System.out.println(today.getYear() - bdate.getYear());
		
		System.out.println(today.isAfter(LocalDate.of(2024, 1, 12)));
		
		System.out.println(today.plusDays(10));
		System.out.println("\n------------FORMATTING----------\n");
		// 1/5/2023
		// 2023-01-05
		//https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy MM dd")));
		System.out.println(today.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
		System.out.println(today.format(DateTimeFormatter.BASIC_ISO_DATE));
		
		LocalDateTime today1 = LocalDateTime.now();
		System.out.println(today1.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
		
		
		System.out.println("welcome".substring(3).toUpperCase());
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("")));
		
 	}

}
