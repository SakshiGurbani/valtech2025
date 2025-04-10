package spring.files;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="lineitem")
public class LineItem {
	
	  @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="lineseq")
	  @SequenceGenerator(name="lineseq",sequenceName = "line_seq" ,allocationSize = 1)
      private int id;
	  
	  @ManyToOne(targetEntity = Item.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	  @JoinColumn(name="item_id",referencedColumnName = "itemId")
	  private Item item;
      private int quantity;
      
      @ManyToOne
//      (targetEntity = Order.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
      @JoinColumn(name="order_id",referencedColumnName = "orderId")
      private Order order;
      
      public LineItem() {}

	public LineItem(Item item, int quantity, Order order) {
		
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
