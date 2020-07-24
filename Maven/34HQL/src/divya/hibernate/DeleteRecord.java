package divya.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import divya.hibernate.entity.Hibusers;

public class DeleteRecord {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Hibusers.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Update record
			
			session.beginTransaction();
			
			session.createQuery("delete from hibusers where first_name = 'riya'" +" AND last_name ='chow'").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
			session.close();
		}
	}

}
