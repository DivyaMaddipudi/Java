
package divya.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import divya.hibernate.entity.Hibusers;

public class UpdateRecord {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Hibusers.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Update record
			
			session.beginTransaction();
			
			session.createQuery("update hibusers set password = 'test' where users_id =1").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
			session.close();
		}
	}

}
