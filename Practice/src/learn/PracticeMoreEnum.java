package learn;

public class PracticeMoreEnum {
	public static void main(String[] args) {
		
		Laptopss lap=Laptopss.Macbook;
		System.out.println(lap);
		
		System.out.println(lap.getPrice());
		
		for(Laptopss l:Laptopss.values()) {
			System.out.println(l+" "+l.getPrice());
		}
		
	}

}

enum Laptopss{
	Macbook(3000),Hp(2000),Asus(1500),Dell(2500);
	
	private int price;
	
	//constructor
	Laptopss(int price){
		this.price=price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
}
