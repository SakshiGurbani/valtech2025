package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practicSpr.A;
import practicSpr.Addition;
import practicSpr.B;
import practicSpr.Certi;
import practicSpr.Child;
import practicSpr.Emp;
import practicSpr.Person;

public class Practice {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("practice.xml");
//		Child ch=ctx.getBean(Child.class);
//		Child ch=(Child)ctx.getBean("child"); //another method
//		System.out.println(ch);
		
//		
//		Emp em=ctx.getBean(Emp.class);
//		Emp em=(Emp)ctx.getBean("emp");//another method
//		System.out.println(em.getEname());
//		System.out.println(em.getAddress());
//		System.out.println(em.getCourse());
//		System.out.println(em.getPhones());
//		System.out.println(em.getProps());
		
		
//		B bb=ctx.getBean(B.class);
//		System.out.println(bb);
//		A aa=ctx.getBean(A.class);
//		System.out.println(aa);
//		System.out.println(aa.getB().getY());
		

		
//		Person p=ctx.getBean(Person.class);
//		System.out.println(p);
//		Certi c=(Certi)ctx.getBean("cer");
//		System.out.println(c);
//		Person p=(Person)ctx.getBean("per");
//		System.out.println(p);
//		System.out.println(p.getList());
		
		Addition a=ctx.getBean(Addition.class);
		System.out.println(a);
		a.doSum();
		
		
		
		ctx.close();
	}

}
 