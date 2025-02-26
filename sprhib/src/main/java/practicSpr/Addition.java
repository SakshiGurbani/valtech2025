package practicSpr;

public class Addition {
	private int a;
	private int b;
	public Addition() {}
	
	
	public Addition(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.println("Constructor int");
	}
	
	public Addition(double a, double b) {
		this.a = (int)a;
		this.b = (int)b;
		System.out.println("Constructor int");
	}
	
	public void doSum() {
		System.out.println("Sum is "+(this.a+this.b));
	}
	
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	

}
