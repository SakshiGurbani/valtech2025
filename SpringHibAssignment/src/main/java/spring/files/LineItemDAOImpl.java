package spring.files;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LineItemDAOImpl implements LineItemDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(LineItem l) {
		new HibernateTemplate(sessionFactory).save(l);
		
	}

	@Override
	public void update(LineItem l) {
		new HibernateTemplate(sessionFactory).update(l);
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));		
	}

    @Override
	public  LineItem get(int id) {
		return new HibernateTemplate(sessionFactory).load(LineItem.class,id);
	}

	@Override
	public List<LineItem> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LineItem l");
	}

	

	

	



}






