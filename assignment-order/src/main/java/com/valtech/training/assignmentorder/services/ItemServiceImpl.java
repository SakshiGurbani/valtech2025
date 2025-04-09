9package com.valtech.training.assignmentorder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignmentorder.entities.Item;
import com.valtech.training.assignmentorder.repos.ItemRepo;
import com.valtech.training.assignmentorder.vos.ItemVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService  {
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public ItemVO getItem(int id) {
		Item i=itemRepo.getReferenceById((long)id);
		return ItemVO.from(i);
	}
	
	@Override
	public List<ItemVO> getAllItem(){
		return itemRepo.findAll().stream().map(it->ItemVO.from(it)).collect(Collectors.toList());
			
	}
	
	@Override
	public ItemVO saveItem(ItemVO ivo) {
		Item i=ivo.to();
		i=itemRepo.save(i);
		return ItemVO.from(i);
	}
         
}


