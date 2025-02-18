package learn;

public class PracticeRunTime {
	
	//dynamic method dispatch
	
	public static void main(String[] args) {
		Aa obj=new Aa();
	    obj.show();
	    
	    obj=new Bb();
	    obj.show();
		
	}

}


class Aa{
	
	public void show() {
		System.out.println("A is called");
	}
	
}


class Bb extends Aa{
	
	public void show() {
		System.out.println("B is callled");
	}
	
}
