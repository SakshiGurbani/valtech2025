package com.valtech.training.assignmentorder.entities;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name="order_info")
public class Order {
	
	
	public enum Status{
		ORDERED,PACKED,DELIVERED,REJECTED
		
	}
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oseq")
	@SequenceGenerator(name= "oseq", sequenceName="o_seq",allocationSize = 1)
	private int orderId;
	
	
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="cusid" ,referencedColumnName="cid")
	private Customer customer;
	
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(targetEntity = LineItem.class,mappedBy = "order",cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private Set<LineItem> lineItems;
	
	
	
	public Order() {}

	public Order(int orderId, Status status) {
		super();
		this.orderId = orderId;
		this.status = status;
	}

	public Order(int orderid, Status status, Customer customer, Set<LineItem> lineItems) {
		this.orderId = orderId;
		this.status = status;
		this.customer = customer;
		this.lineItems = lineItems;
	}
	
	public Order(int orderId, Customer customer, Set<LineItem> lineItems) {
		
		this.orderId = orderId;
		this.customer = customer;
		this.lineItems = lineItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderid(int orderId) {
		this.orderId = orderId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void addItems(LineItem li) {
		if(lineItems==null) lineItems=new HashSet<LineItem>();
		lineItems.add(li);
		li.setOrder(this);
		
	}
	
	public void removeItems(LineItem li) {
		lineItems.remove(li);
		li.setOrder(null);
	}

	
	
	
	
	
	
	
	

}

