package spring.files;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
	
	
	public enum Status{
		PACKED,ONTHEWAY,DELIVERED,NOTDELIVERED
		
	}
	
	@Id
	private int orderid;
	private Status status;
	
	public Order() {}
	
	

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
	

}
