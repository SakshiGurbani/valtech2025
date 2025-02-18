package learn;

public class PracticeThrow {
	public static void main(String[] args) {
		
		int i=20;
		int j=0;
		
		
		try {
			j=18/i;//quotient will be zero but no exception 
			if(j==0)  //to create deliberately exception
				throw new ArithmeticException("I dont want to print zero");
			
		}
		catch(ArithmeticException e){
			j=18/1;
			System.out.println("Default Message "+e);
			
		}
		catch(Exception e) {
			System.out.println("something went wrong"+e);
		}
		
		
	}
	

}
