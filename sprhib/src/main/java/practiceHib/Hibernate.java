package practiceHib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Hibernate  {
	
	public static void main(String[] args) throws IOException {
		SessionFactory sesFac=new AnnotationConfiguration()
				.addAnnotatedClass(Students.class)
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();
		
		Session ses=sesFac.openSession();
		Transaction tx=ses.beginTransaction();
//		Students st=new Students();
//		st.setId(3);
//		st.setName("Kushal");
//		st.setCity("Jaipur");
//		st.setYear(2020);
//		ses.save(st);
		
//		Students st=new Students(1,"Sakshi","Jaipur",2020);
//		ses.save(new Students(2,"Aesha","Ahemdabad",2019));
//		ses.save(new Students(3,"Kushal","Jaipur",2020));
//		st.setName("Sakshi");
		
		
		
		
		Address ad=new Address();
		ad.setStreet("Kiran Path");
		ad.setCity("Jaipur");
		ad.setOpen(true);
		ses.save(ad);
		ad.setAddDate(new Date());
		
		//reading image
		FileInputStream fis=new FileInputStream("src/main/java/hidden.jpg");
		byte[]data=new byte[fis.available()];
		fis.read();
		ad.setImage(data);
		
		
		ses.update(ad);
//		ses.update(st);
		tx.commit();
		ses.close();
		sesFac.close();
	}

}
