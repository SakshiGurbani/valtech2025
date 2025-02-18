package learn;

public class PracticeEncap {
	
	public static void main(String args[]) {
		
		Me m1=new Me();
//		m1.setAge(20);
//		m1.setName("Sakshi");
	    Me m2=new Me(21,"Devika");
		System.out.println(m1.getAge() +"," +m1.getName());
		System.out.println(m2.getAge() +"," +m2.getName());
		
		
	}

}

class Me{
	
	private int age;
	private String name;
	
	
	public Me() {
		age=20;
		name="Gunjan";
		
	}
	
	public Me(int age,String name) {
		
		this.age=age;
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int a) {
		age=a;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name=n;
	}
	
	
}
