package spring.files;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;


public class ItemHibernateDAOImpl implements ItemDAO{
	
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Item i) {
		new HibernateTemplate(sessionFactory).save(i);
		
	}

	@Override
	public void update(Item i) {
		new HibernateTemplate(sessionFactory).update(i);
		
	}

	@Override
	public void delete(int itemId) {
		new HibernateTemplate(sessionFactory).delete(get(itemId));		
	}

    @Override
	public  Item get(int itemId) {
		return new HibernateTemplate(sessionFactory).load(Item.class,itemId);
	}

	@Override
	public List<Item> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Item i");
	}

	

	



}



