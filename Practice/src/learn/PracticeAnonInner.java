package learn;

public class PracticeAnonInner {
	
	public static void main(String[] args) {
		
		Try t=new Try() {
			public void dance() {
				System.out.println("Not Dance Baby");
			}
		};
		
		
		t.dance();
		
		
	}

}


class Try{
	
	public void dance() {
		System.out.println("Hey Sakshi,Lets Dance");
	}
}
