package spring.files;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


	@Service
//	@Transactional(propagation = Propagation.SUPPORTS)
	public class CustomerServiceImpl implements CustomerService {
		 
		
		@Autowired
		private CustomerDAO customerDAO;
		
		public void setCustomerDAO(CustomerDAO customerDAO) {
			this.customerDAO = customerDAO;
		}
		
		@Override
		@Transactional
		public void save(Customer c) {
			customerDAO.save(c);

		}
       
		
		@Override
		@Transactional(propagation = Propagation.REQUIRED)
		public void update(Customer c) {
			customerDAO.update(c);

		}
      
		@Override
		public void delete(int cid) {
			customerDAO.delete(cid);
		}
        
		
		@Override
		public Customer get(int cid) {
			return customerDAO.get(cid);
		}
        
		
		@Override
		public List<Customer> getAll() {
			return customerDAO.getAll();
		}
 
		
	
	}
