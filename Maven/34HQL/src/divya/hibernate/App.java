package divya.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import divya.hibernate.entity.Hibusers;

public class App {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Hibusers.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//Listing records
			
			//start the transaction
			session.beginTransaction();
			
			List<Hibusers> users = session.createQuery("from hibusers").getResultList();
			
			for(Hibusers temp: users) {
				System.out.println(temp);
			}
			
			//commit the transaction
			//session.getTransaction().commit();
			
		}finally {
			factory.close();
			session.close();
		}
		
	}
}
