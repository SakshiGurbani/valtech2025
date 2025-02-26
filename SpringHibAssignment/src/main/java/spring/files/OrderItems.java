package spring.files;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderItems {
	
	  @Id
      private int id;
      private int quantity;
      

}
