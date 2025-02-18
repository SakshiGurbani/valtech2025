package learn;

public class PracticeInner {
	
	public static void main(String[] args) {
		
		D d1=new D();
		d1.play();
//		D.A obj=d1.new A();
//		obj.dance();
		D.A obj=new D.A();
		obj.dance();
		
	}

}

class D{
	int age;
	
	public void play() {
		System.out.println("I am playing");
	}
	
	static class A{
		
		public void dance() {
			System.out.println("Dancing");
		}
	}
	
	
	
	
}


