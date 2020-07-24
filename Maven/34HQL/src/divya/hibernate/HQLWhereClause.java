package divya.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import divya.hibernate.entity.Hibusers;

public class HQLWhereClause {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Hibusers.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Using where clause
			
			session.beginTransaction();
			List<Hibusers> users = session.createQuery("from hibusers where username = 'Divya'" + "OR users_id = 1").getResultList();
			
			for(Hibusers temp:users) {
				System.out.println(temp);
			}
			
		} finally {
			factory.close();
			session.close();
		}
	}

}
