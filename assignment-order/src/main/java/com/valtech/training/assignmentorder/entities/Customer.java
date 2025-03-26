package com.valtech.training.assignmentorder.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "customer_info")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custseq")
	@SequenceGenerator(name = "custseq", sequenceName = "cust_seq", allocationSize = 1,initialValue=1)
	private int cid;
	private String name;
	private int age;
	private String address;
	private String perAdd;

	public enum CustomerStatus {
		ENABLE, DISABLE
	}

	@Enumerated(EnumType.STRING)
	private CustomerStatus customerStatus;
	
	@OneToMany(targetEntity = Order.class, mappedBy = "customer", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Set<Order> orders;

	public Customer() {
	}

	public Customer(int cid,String name, int age, String address, String perAdd, CustomerStatus customerStatus) {
		this.cid=cid;
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAdd = perAdd;
		this.customerStatus = customerStatus.ENABLE;
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

	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}

//	@Override
//	public String toString() {
//		return "Customer [cid=" + cid + ", name=" + name + ", age=" + age + ", address=" + address + ", perAdd="
//				+ perAdd + ", orders=" + orders + "]";
//	}

}
