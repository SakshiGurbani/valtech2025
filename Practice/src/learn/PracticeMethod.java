package learn;

public class PracticeMethod {
	
	public static void main(String[] args) {
		Computer c=new Computer();
		c.play();
		 System.out.println(c.pen(5));
		 
		Calculator c1=new Calculator();
		System.out.println(c1.add(3, 4, 8));
		c1.add1(4, 5);
		c1.add(4,5,6);
		
		
	}

}

class Computer{
	  public void play() {
		  System.out.println("Play a game that you like");
	  }
	  
	  public String pen(int cost) {
		  if(cost>=10)
		  return "Pen";
		  else
			  return "Not a pen";
	  }
	
}


class Calculator{
	public int add(int n1,int n2,int n3) {
		return n1+n2+n3;
	}
	
	public int add1(int n1,int n2){
		return n1+n2;
	}
	
	public double add(double n1,double n2,double n3) {
		return n1+n2+n3;
	}
}
