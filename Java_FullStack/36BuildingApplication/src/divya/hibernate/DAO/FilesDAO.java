package divya.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import divya.hibernate.entity.Files;

public class FilesDAO {

	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Files.class)
			.buildSessionFactory();

	public void addFileDetails(Files file) {
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		session.save(file);
		session.getTransaction().commit();
		System.out.println(file.getFileName()+"Got added");
	}
	
	public List<Files> listFiles() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Files> files = session.createQuery("from files").getResultList();
//		session.getTransaction().commit();
		
		return files;
	}
	
	public void updateInformation(int id, String label, String caption) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		//Getting handle for that row to update specific values
		Files file = session.get(Files.class, id);
		file.setLabel(label);
		file.setCaption(caption);
		session.getTransaction().commit();
	}
}
