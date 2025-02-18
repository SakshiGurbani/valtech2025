package learn;


class SakshiException extends Exception{
	public SakshiException(String str) {
		super(str);
	}
}



class PracticeCustomException {
	public static void main(String[] args) {
		int i=20;
		int j=0;
		
		try {
			j=18/i;
			if(j==0)
				throw new SakshiException("I dont wanna loose");
		}
		catch(SakshiException s) {
			j=18/1;
			System.out.println("default output "+s);
			
		}
		catch(Exception e) {
			System.out.println("something went wrong");
		}
		
	}
}