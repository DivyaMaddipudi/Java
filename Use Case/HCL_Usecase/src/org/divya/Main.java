package org.divya;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter student details");
		
		String firstName = sc.nextLine();
		String lastName = sc.nextLine();
		String major = sc.nextLine();
		int age = sc.nextInt();
		char gender = sc.next().charAt(0);
		
		
		Student student = new Student(firstName, lastName, age, gender, major);
		
		System.out.println("Full name:" + student.getFirstName() + " " +student.getLastName());
		System.out.println(student.getAge());
		
		if(student.getGender() == 'f') {
			System.out.println("female");
		} else {
			System.out.println("male");
		}
	}

}
