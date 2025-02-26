package teluskoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import practiceHib.Address;
import practiceHib.Students;

public class Hiber {
	
	public static void main(String[] args) {
		
		SessionFactory sesFac=new AnnotationConfiguration()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session ses=sesFac.openSession();
		Transaction tx=ses.beginTransaction();
		
		Student s=new Student();
		s.setSrollno(1);
		s.setsName("Sakshi");
		s.setsAge(20);
		
		
		
		tx.commit();
		ses.close();
		sesFac.close();
	}

}
