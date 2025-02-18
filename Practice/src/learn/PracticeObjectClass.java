package learn;

public class PracticeObjectClass {
	
	public static void main(String[] args) {
		Laptop l1=new Laptop();
		l1.price=50000;
		l1.name="Macbook";
		
		Laptop l2=new Laptop();
		l2.price=50000;
		l2.name="Macbook";
		
		boolean result=l1.equals(l2);
		System.out.println(result);
	}

}

class Laptop{
	
	int price;
	String name;
	
	public String toString() {
//		return "Hello Sakshi";
		return price + " " + name;
	}
	
	public boolean equals(Laptop lap) {
		return this.name.equals(lap.name) && this.price==lap.price;
	}
	
	
}
