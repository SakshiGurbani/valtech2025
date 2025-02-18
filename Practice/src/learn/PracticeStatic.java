package learn;

public class PracticeStatic {
	
	public static void main(String[] args) {
		
		Mobile m1=new Mobile();
		m1.price=1500;
		m1.name="redmi";
		
		
		Mobile m2=new Mobile();
		m2.price=1000;
		m2.name="oppo";
		
		
	m1.name="Apple";
	m1.show();
//	m2.show();
	
	
		
		
	}

}

class Mobile{
	int price;
	 static String name;
	
	public void show() {
		System.out.println(price + ":" + name);
	}
	
	//static method
	
	public static void show1(Mobile m1) {
		System.out.println(m1.price + ":" + name);
	}
	
	static {
		name="SmartPhone";
		System.out.println("static block");
	}
	
	
	public Mobile() {
		price=2000;
		System.out.println("constructor");
	}
}
