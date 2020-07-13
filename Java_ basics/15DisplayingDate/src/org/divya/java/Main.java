package org.divya.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
	
	public static void main(String[] args) {
		
		LocalDateTime currentDate;
		
		currentDate = LocalDateTime.now();
		System.out.println("Current date is: " + currentDate);
		
		//Formatted Date
		
		String fDate = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println("Formatted date is: " +fDate);
		
		String fDate1 = currentDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
		System.out.println("Formatted date in style medium is: "+ fDate1);
		
	}

}
