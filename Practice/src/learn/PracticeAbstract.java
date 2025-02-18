package learn;

public class PracticeAbstract {
	 
	public static void main(String[] args) {
		Car c1=new Updated();
		c1.music();
		c1.drive();
		c1.fly();
		
	}

}

abstract class Car{
	 public abstract void drive();
	 public abstract void fly();
	 
	 public void music() {
		 System.out.println("Music is playing");
	 }
	
	
}

abstract class VolksWagen extends Car{
	
	public void drive() {
		System.out.println("Driving");
	}
	

	
	
}

class Updated extends VolksWagen{
	
	public void fly() {
		System.out.println("Flying");
	}
}
