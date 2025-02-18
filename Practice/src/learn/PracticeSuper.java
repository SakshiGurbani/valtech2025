package learn;

public class PracticeSuper {
	
	public static void main(String args[]) {
		B b1=new B();
		System.out.println(b1.show(5));
		
		
		
	}

}


class A{
	 

	public A() {
		super();
		System.out.println("Constructor of A");
	}
	
	public A(int n) {
		super();
		System.out.println("parameter vala A");
	}
	
	public int show(int n1) {
		return n1;
	}
	
}

class B extends A{
	
	public B() {
		super();
		
		System.out.println("Constructor of B");
	}
	
	public B(int n) {
		this();
//		super();
		System.out.println("parameter vala B");
	}
	
	public int show(int n1) {
		return n1+2;
	}
	
	
}
