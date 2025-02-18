package learn;

public class PracticeMoreInterface {
	public static void main(String[] args) {
		Computers l=new Laptops();
		Computers d=new Desktop();
		Developer dev=new Developer();
		dev.develop(d);
		
	}

}
interface Computers{

 void code();
		
		
	
	
}

class Desktop implements Computers{
	public void code() {
		System.out.println("Code Desktop");
	}
}

class Laptops implements Computers{
	
	public void code() {
		System.out.println("Code");
	}
}

class Developer {
	public void develop(Computers lap) {
		lap.code();
	}
}
