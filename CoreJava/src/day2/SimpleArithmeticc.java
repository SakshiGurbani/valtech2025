package day2;

public class SimpleArithmeticc implements Arithmetic {

	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	  
		

	}

	@Override
	public double sub(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
		
		
		

	}

	@Override
	public double mul(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;


	}

	@Override
	public double div(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
		

	}
	
	public static void main(String[] args) {
		
		SimpleArithmeticc obj= new SimpleArithmeticc();
		System.out.println(obj.add(10, 20));
		System.out.println(obj.sub(10, 20));
		System.out.println(obj.mul(10,20));
		System.out.println(obj.mul(10,20));
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

	
	
	
