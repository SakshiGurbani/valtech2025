package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practicSpr.A;
import practicSpr.B;
import practicSpr.Certi;
import practicSpr.Child;
import practicSpr.Emp;
import practicSpr.Person;

public class Practice {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("practice.xml");
//		Child ch=ctx.getBean(Child.class);
//		Child ch=(Child)ctx.getBean("child");
//		System.out.println(ch);
		
		
//		Emp em=ctx.getBean(Emp.class);
//		Emp em=(Emp)ctx.getBean("employee");
//		System.out.println(em.getEname());
//		System.out.println(em.getAddress());
//		System.out.println(em.getCourse());
//		System.out.println(em.getPhones());
//		System.out.println(em.getProps());
		
		
		
//		B bb=(B)ctx.getBean("bref");
//		System.out.println(bb);
//		A aa=(A)ctx.getBean("aref");
//		System.out.println(aa);
//		System.out.println(aa.getB().getY());
		
		
		Certi c=(Certi)ctx.getBean("cer");
		System.out.println(c);
		Person p=(Person)ctx.getBean("per");
		System.out.println(p);
//		System.out.println(p.getList());
		
		
		
		ctx.close();
	}

}
 