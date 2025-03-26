package spring.files;

public interface InventoryService {


	void addInventory(Item item);

	void updateInventory(int itemId, int newQuantity);

}