package com.valtech.training.assignmentorder.services;

import java.util.List;

import com.valtech.training.assignmentorder.vos.ItemVO;

public interface ItemService {

//	ItemVO getItem(long id);

	List<ItemVO> getAllItem();

	ItemVO saveItem(ItemVO ivo);

	ItemVO getItem(int id);

}