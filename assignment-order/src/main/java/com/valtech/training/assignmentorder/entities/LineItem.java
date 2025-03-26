package com.valtech.training.assignmentorder.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LineItem {
	
	  @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="lineseq")
	  @SequenceGenerator(name="lineseq",sequenceName = "line_seq" ,allocationSize = 1)
      private int id;
	  
	  @ManyToOne(targetEntity = Item.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	  @JoinColumn(name="item_id",referencedColumnName = "itemId")
	  private Item item;
      private int quantity;
      
      @ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
      @JoinColumn(name="order_id",referencedColumnName = "orderId")
      private Order order;
      
      public LineItem() {}
	public LineItem(int quantity) {
		this.quantity = quantity;
	}
	public LineItem(int id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}
	
	public LineItem(int id, Item item, int quantity, Order order) {
		
		this.id = id;
		this.item = item;
		this.quantity = quantity;
		this.order = order;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
      
      
      

}
