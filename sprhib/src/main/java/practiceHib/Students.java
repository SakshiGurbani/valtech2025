package practiceHib;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Students {
	
	@Id
	private int id;
	private String name;
	private String city;
	private int year;
	
	public Students() {}

	public Students(int id, String name, String city, int year) {
		
		this.id = id;
		this.name = name;
		this.city = city;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
