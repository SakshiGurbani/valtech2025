package learn;

public class PracticeClass {
	
	public static void main(String[] args) {
		 Student s1=new Student();
		
		 System.out.println( s1.add(4, 8));
	}

}

class Student{
	
	public int add(int n1,int n2) {
		int r=n1+n2;
		return r;
	}
	
}
