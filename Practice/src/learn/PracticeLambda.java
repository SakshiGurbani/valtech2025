package learn;

public class PracticeLambda {
	public static void main(String[] args) {
		
		Expression exp=(i,j)-> System.out.println("Asha Sharma"+i+" "+" "+j);
		exp.show(23,20);
		Practices prac=(i,j)->i+j;
		
		System.out.println(prac.add(4, 5));
	}

}

interface Expression{
	void show(int i,int j);
	
	
}

interface Practices{
	int add(int i,int j);
}
