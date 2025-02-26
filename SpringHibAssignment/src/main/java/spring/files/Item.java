package spring.files;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "itseq")
	@SequenceGenerator(name= "itseq", sequenceName="it_seq",allocationSize = 1)
	private int itemId;
	private String name;
	private String descrip;
	private int currQuant;
	private int reOrderQuant;
	private int maxQuant;
	
	
	public Item() {}
	
	
	public Item( String name, String descrip, int currQuant, int reOrderQuant, int maxQuant) {
		
		
		this.name = name;
		this.descrip = descrip;
		this.currQuant = currQuant;
		this.reOrderQuant = reOrderQuant;
		this.maxQuant = maxQuant;
	}


	public int getId() {
		return itemId;
	}
	public void setId(int id) {
		this.itemId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public int getCurrQuant() {
		return currQuant;
	}
	public void setCurrQuant(int currQuant) {
		this.currQuant = currQuant;
	}
	public int getReOrderQuant() {
		return reOrderQuant;
	}
	public void setReOrderQuant(int reOrderQuant) {
		this.reOrderQuant = reOrderQuant;
	}
	public int getMaxQuant() {
		return maxQuant;
	}
	public void setMaxQuant(int maxQuant) {
		this.maxQuant = maxQuant;
	}


	@Override
	public String toString() {
		return "Item [id=" + itemId + ", name=" + name + ", descrip=" + descrip + ", currQuant=" + currQuant
				+ ", reOrderQuant=" + reOrderQuant + ", maxQuant=" + maxQuant + "]";
	}
	
	
	
	
	

}
