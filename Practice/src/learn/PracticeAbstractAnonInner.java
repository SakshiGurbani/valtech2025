package learn;

public class PracticeAbstractAnonInner {
	public static void main(String[] args) {
		P p1=new P() {
			public void show() {
				System.out.println("Show");
			}
			
			public void dance() {
				System.out.println("Dance");
			}
		};
		
		p1.show();
		p1.dance();
		
		
	}

}

abstract class P{
	
	public abstract void show();
	public abstract void dance();
	
}
