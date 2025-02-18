package learn;

public class PracticeException {
	
	public static void main(String[] args) {
		
		int i=2;
		int j=0;
		
		int nums[]=new int[4];
		String str=null;
		
		try {
			j=18/i;
			System.out.println(nums[2]);
			System.out.println(str.length());
		}catch(ArithmeticException e) {
			System.out.println("Cannot divide by zero"+e);
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("limit");
		}catch(Exception e) {
			System.out.println("By default"+e);
		}
	}

}
