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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="order_info")
public class Order {
	
	
	public enum Status{
		ORDERED,PACKED,DELIVERED,NOTDELIVERED
		
	}
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oseq")
	@SequenceGenerator(name= "oseq", sequenceName="o_seq",allocationSize = 1)
	private int orderId;
	
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="cusid" ,referencedColumnName="cid")
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(targetEntity = LineItems.class,mappedBy = "order",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<LineItems> lineItems;
	
	
	
	public Order() {}

	public Order(int orderid, Status status, Customer customer, Set<LineItems> lineItems) {
		this.orderId = orderId;
		this.status = status;
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



	public Set<LineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItems> lineItems) {
		this.lineItems = lineItems;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	

	
	
	
	
	
	
	
	

}
