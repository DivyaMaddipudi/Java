package org.divya;

import java.util.Scanner;

import org.model.Name;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Enter student details");
//		
//		String firstName = sc.nextLine();
//		String lastName = sc.nextLine();
//		String major = sc.nextLine();
//		int age = sc.nextInt();
//		char gender = sc.next().charAt(0);
//		
//		
//		Student student = new Student(firstName, lastName, age, gender, major);
//		
//		System.out.println("Full name:" + student.getFirstName() + " " +student.getLastName());
//		System.out.println(student.getAge());
//		
//		if(student.getGender() == 'f') {
//			System.out.println("female");
//		} else {
//			System.out.println("male");
//		}
		
		String searchName = sc.next();
		
		Name[] name = new Name[4];
		
		name[0] = new Name(1, "divya");
		name[1] = new Name(2, "john");
		name[2] = new Name(3, "doe");
		name[3] = new Name(4, "divya");
		
		for(int i=0;i<name.length;i++) {
			if(name[i].getEmployeeName().equals(searchName)) {
				System.out.println(name[i].toString());
			}	
		}
		
		
	}

}
