package spring.files;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer_info")
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
	@SequenceGenerator(name= "custseq", sequenceName="cust_seq",allocationSize = 1)
	private int cid;
	private String name;
	private int age;
	private String address;
	private String perAdd;
	
	@OneToMany(targetEntity = Order.class,mappedBy = "customer",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	 private Set<Order>orders;
	
	public enum CustomerStatus{
		ENABLE,DISABLE
	}
	@Enumerated(EnumType.STRING)
	private CustomerStatus customerStatus;
	
	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}
	public Customer() {}

	public Customer(String name, int age, String address, String perAdd, 
			CustomerStatus customerStatus) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAdd = perAdd;
		this.customerStatus = customerStatus;
	}
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPerAdd() {
		return perAdd;
	}

	public void setPerAdd(String perAdd) {
		this.perAdd = perAdd;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", age=" + age + ", address=" + address + ", perAdd="
				+ perAdd + ", orders=" + orders + "]";
	}
	
	

}
