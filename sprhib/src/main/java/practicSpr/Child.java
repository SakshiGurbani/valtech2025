package practicSpr;

public class Child {
	
	private int id;
	private String name;
	private String place;
	
	public Child() {}
	
	

	public Child(int id, String name, String place) {
		
		this.id = id;
		this.name = name;
		this.place = place;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("Setting Student Id");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Child [id=" + id + ", name=" + name + ", place=" + place + "]";
	}
	
	
	
	

}
