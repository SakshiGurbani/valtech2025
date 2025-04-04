package spring.files;

import java.util.List;


public interface CustomerService {

	void save(Customer c);

	void update(Customer c);

	void delete(int cid);

	Customer get(int cid);

	List<Customer> getAll();

}
