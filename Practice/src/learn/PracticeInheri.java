package learn;

public class PracticeInheri {
	
	public static void main(String args[]) {
		VeryAdvanceCalc c1=new VeryAdvanceCalc();
		int r1=c1.add(5, 4);
		int r2=c1.mul(5, 4);
		int r3=c1.sub(5, 4);
		int r4=c1.div(5, 4);
		double r5=c1.power(2,3);
		System.out.println(r1 +"," +r2 +","+","+ r3 +"," +r4 + ","+ r5);
		
	}

}


class Calc{
	public int add(int n1,int n2) {
		return n1+n2;
	}
	
	public int mul(int n1,int n2) {
		return n1* n2;
	}
}

class AdvanceCalc extends Calc{
	
	public int sub(int n1,int n2) {
		return n1-n2;
	}
	
	public int div(int n1,int n2) {
		return n1/n2;
	}
}


class VeryAdvanceCalc extends AdvanceCalc{
	
	public double power(int n1,int n2) {
		return Math.pow(n1, n2);
	}
}
