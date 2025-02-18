package learn;

public class PracticeEnum {
	public static void main(String[] args) {
	
//		System.out.println(s);
//		System.out.println(s.ordinal());
		//print all values
		Status [] ss=Status.values();
		
		for( Status sss:ss) {
			System.out.println(sss);
		}
		
		Status s=Status.Running;
		switch(s) {
		
		case Running:
			System.out.println("Good");
			break;
		case Failed:
			System.out.println("Try Again");
			break;
		case Success:
			System.out.println("Excellent");
		}
		
	}

}

enum Status{
	Running,Failed,Success;
}
