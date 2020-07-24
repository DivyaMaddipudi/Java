package org.divya.hibernate;

import org.divya.hibernate.entity.Hibusers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Hibusers.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			/*
			//Adding data into db.
			// Create object of entity class type
			Hibusers user = new Hibusers("username", "password", "firstName", "lastName");
			
			// Start transaction
			session.beginTransaction();
			// Perform operation
			session.save(user);
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Row added!");
			*/
			
			/*
			//Retriving data from db.
			
			Hibusers user = new Hibusers();
			
			session.beginTransaction();
			
			user = session.get(Hibusers.class, 4);
			
			session.getTransaction().commit();
			System.out.println(user);
			*/
			
			/*
			 //Update user
			Hibusers user = new Hibusers();
			session.beginTransaction();
			
			user = session.get(Hibusers.class, 4);
			user.setUsername("divya");
			session.getTransaction().commit();
			System.out.println(user);
			
			*/
			
			//Delete user
			Hibusers user = new Hibusers();
			session.beginTransaction();
			
			user = session.get(Hibusers.class, 2);
			
			//Deleting a record with user id 3
			session.delete(user);
			
			System.out.println(user);
			session.getTransaction().commit();
			
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
