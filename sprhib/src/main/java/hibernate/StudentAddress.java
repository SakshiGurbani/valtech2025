package hibernate;

import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public class StudentAddress {
	
	private String street;
	private String city;
	private int pinCode;
	
	
	
	
	public StudentAddress() {}

	public StudentAddress(String street, String city, int pinCode) {
		super();
		this.street = street;
		this.city = city;
		this.pinCode = pinCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, pinCode, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentAddress other = (StudentAddress) obj;
		return Objects.equals(city, other.city) && pinCode == other.pinCode && Objects.equals(street, other.street);
	}
	
	
	
	
	

}
