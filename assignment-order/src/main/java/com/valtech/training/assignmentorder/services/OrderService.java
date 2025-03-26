package com.valtech.training.assignmentorder.services;

import java.util.List;

import com.valtech.training.assignmentorder.entities.Item;
import com.valtech.training.assignmentorder.vos.OrderVO;
import com.valtech.training.assignmentorder.vos.PlaceOrderVO;

public interface OrderService {

	void resetInventory(Item item);

	void save(PlaceOrderVO pvo);

	OrderVO update(OrderVO orderVO);

	void delete(int id);

	OrderVO get(int id);

	List<OrderVO> getAll();

}