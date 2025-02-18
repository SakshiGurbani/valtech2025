package day2;

import java.util.Iterator;

public class ControlStatements {
	
	public void testIfElse(int a) {
		
		if(a%2==0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
	}
	
	
	
	public void testfor(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			
		}
		
	}
	
	
	
	public void testSwitch(int a) {
		switch(a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		default:
			System.out.println("All");
		
		}
	}
	
	
	
	public int add(int iv,int ... a) {
		int sum=iv;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		System.out.println(sum);
		return sum;
	}
	
	public static void main(String[] args) {
		ControlStatements cs=new ControlStatements();
		cs.testIfElse(6);
		cs.testIfElse(5);
		cs.testfor(new int[] {1,2,3,4});
		cs.testSwitch(1);
		cs.testSwitch(5);
		
		cs.add(1,2,3);
		cs.add(1,2,3,4,5,6);
		
	}

}
