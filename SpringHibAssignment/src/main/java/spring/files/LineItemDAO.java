package spring.files;

import java.util.List;

import javax.sound.sampled.Line;

public interface LineItemDAO {
	
	void save(LineItem l);

	void update(LineItem l);

	void delete(int lid);

	LineItem get(int lid);

	List<LineItem> getAll();

	

}
