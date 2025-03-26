package spring.files;

import org.springframework.beans.factory.annotation.Autowired;

public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private ItemDAO itemDAO;
	
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO=itemDAO;
	}
	
	
	@Override
	public void addInventory(Item item) {
		item.setCurrQuant(item.getMaxQuant());
		item.setReOrderQuant(0);
		itemDAO.update(item);
	}
	
	@Override
	public void updateInventory(int itemId,int newQuantity) {
		Item item=itemDAO.get(itemId);
		
		if(item!=null) {
			item.setCurrQuant(newQuantity);
			item.setReOrderQuant(Math.max(item.getMaxQuant()-newQuantity,0));
			
			itemDAO.update(item);
		}
	}

}
