package com.valtech.training.assignmentorder.vos;

import com.valtech.training.assignmentorder.entities.Item;

public record ItemVO(int itemId,String name,String descrip,int currQuant,int reOrderQuant,int maxQuant) {

	
	public static  ItemVO from(Item i) {
		return new ItemVO(i.getId(), i.getName(), i.getDescrip(), i.getCurrQuant(), i.getReOrderQuant(), i.getMaxQuant());	
	}
	
	public Item to() {
		return new Item(itemId, name,descrip,currQuant,reOrderQuant,maxQuant);
	}
}
