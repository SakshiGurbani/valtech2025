package com.valtech.training.assignmentorder.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.assignmentorder.entities.Item;
import com.valtech.training.assignmentorder.entities.LineItem;
import com.valtech.training.assignmentorder.entities.Order;

public record LineItemVO(int id,int quantity,Item item,Order order) {
	
	public static LineItemVO from(LineItem  li) {
		return new LineItemVO(li.getId(),li.getQuantity(),li.getItem(),li.getOrder());
	}
	
	public LineItem to() {
		return new LineItem(id,item,quantity,order);
	}
	
	public static List<LineItemVO>from (List<LineItem>li){
		return li.stream().map(lis->LineItemVO.from(lis)).collect(Collectors.toList());
	}

}
