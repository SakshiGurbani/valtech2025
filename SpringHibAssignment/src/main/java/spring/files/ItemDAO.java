package spring.files;

import java.util.List;

public interface ItemDAO {
	

	void save(Item i);

	void update(Item i);

	
	void delete(int itemId);
	Item get(int itemId);

	List<Item> getAll();



}
