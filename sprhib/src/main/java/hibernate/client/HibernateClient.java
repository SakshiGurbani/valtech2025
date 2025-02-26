package hibernate.client;

import java.beans.Customizer;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import hibernate.Account;
import hibernate.Address;
import hibernate.AtmTx;
import hibernate.Car;
import hibernate.ChequeTransaction;
import hibernate.Customer;
import hibernate.Student;
import hibernate.StudentAddress;
import hibernate.StudentId;
import hibernate.TellerTx;
import hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args) {
		SessionFactory sesFac=new AnnotationConfiguration()
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(Tx.class)
				.addAnnotatedClass(ChequeTransaction.class)
				.addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		System.out.println(sesFac);
		Session ses=sesFac.openSession();
//		System.out.println(ses);
		Transaction tx=ses.beginTransaction();
		
//		ses.createQuery("FROM Tx t").list().stream().forEach(t->System.out.println(t));
		
//		ses.createQuery("FROM Customer c WHERE c.age>?")
//		.setInteger(0, 25).list().stream().forEach(t->System.out.println(t));
		
		ses.createQuery("Select t.account.id,t.amount FROM Tx t JOIN t.account.customer c WHERE c.age<?")
		.setInteger(0, 25)
		.list().stream().forEach(t->System.out.println(t));
		
		
//		
		
//		StudentId id=(StudentId)ses.save(new Student(new StudentId(1,2025),"Abc","Def","CS",9887877654L,
//				new StudentAddress("SomeWhere","Ahm",343432),
//				new StudentAddress("NoWhere","Raj",302020)));
//		System.out.println(ses.load(Student.class, id));
		
		//those object are already loaded will not be loaded by session again
		//pk is null or zero (he will save the query)
//		Long id=(Long)ses.save(new Car(0,"Honda","City",2025));
//		System.out.println(id);
//		Car car=(Car)ses.load(Car.class,id);
//		System.out.println(car);
//		car.setName("Civic");
//		Car car1=(Car)ses.load(Car.class,id);
//		ses.update(car);
//		ses.flush();
//	Car car2=(Car)ses.load(Car.class,id);
//		System.out.println(car);
//		System.out.println(car.getClass().getName());
		
	
//		Account acc=(Account) ses.load(Account.class, 1L);
//		Customer cus=(Customer) ses.load(Customer.class, 1L);
//		
//		Account acc1=new Account(30000,"SB");
//		Account acc2=new Account(50000,"CA");
//		
//		Customer cus1=new Customer("DEF",32,false);
//		Customer cus2=new Customer("XYZ",36,false);
//		
//		ses.save(acc1);
//		ses.save(cus1);
//		ses.save(acc2);
//		ses.save(cus2);
//		
//		cus.addAccount(acc);
//		cus.addAccount(acc1);
//		cus.addAccount(acc2);
//		cus1.addAccount(acc);
//		cus1.addAccount(acc1);
//		cus2.addAccount(acc);
//		
		
//		List<Tx>txs=ses.createQuery("from Tx t").list();
//		Account acc=new Account(1000, "SB");
//		ses.save(acc);
//		txs.stream().forEach(t-> acc.addTx(t));
//		
		
//		Customer c=(Customer) ses.load(Customer.class, 1L);
//		System.out.println(c);
//		System.out.println(c.getAddress());
		
//		Customer c=new Customer("Abc",23,true);
//		ses.save(c);
//		Address a=new Address("Jayanagar","Jpr",302020);
//		c.setAddress(a);
//		a.setCustomer(c);
//		a.setId(c.getId());
//		ses.saveOrUpdate(a);
//		
//	
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTransaction(2000,123456));
//		ses.save(new TellerTx(3000,"Admin","Jayanagar"));
//		ses.save(new AtmTx(4000,123));
////		
//		List<Tx>txs=ses.createQuery("from Tx t").list();
//		System.out.println(txs);
	
//		
		
		//those object are already loaded will not be loaded by session again
//		//pk is null or zero (he will save the query)
//		Long id=(Long)ses.save(new Car(0,"Honda","City",2025));
//		Car car=(Car)ses.load(Car.class,id);
//		car.setName("Civic");
//		ses.update(car);
//		Car car1=(Car)ses.load(Car.class,id);
//		Car car2=(Car)ses.load(Car.class,id);
//		System.out.println(car.getClass().getName());
		
		tx.commit();
		ses.close();
		sesFac.close();
				

	}

}
