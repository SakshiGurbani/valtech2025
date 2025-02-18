package learn;

public class MoreInterface {
	public static void main(String[] args) {
		F a;
		a=new E(); 
		a.show();
		a.dance();
		X x;
		x=new E();
		x.sing();
	}

}

interface F{
	
	void show();

	void dance();
}
interface X{
	void sing();
}

class E implements F,X{
	public void show() {
		System.out.println("Show");
	}
	
	public void dance() {
		System.out.println("Dance");
	}
	
	public void sing() {
		System.out.println("Sing");
	}
}



interface Y extends X{
	void run();
}
