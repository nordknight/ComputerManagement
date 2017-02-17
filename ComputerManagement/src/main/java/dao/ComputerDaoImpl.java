package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import domain.Computer;

@Repository
public class ComputerDaoImpl implements ComputerDao{

	private static final Logger logger = LoggerFactory.getLogger(ComputerDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addComputer(Computer c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Computer saved successfully, Computer Details="+c);		
	}

	@Override
	public void updateComputer(Computer c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Computer updated successfully, Computer Details="+c);
		
	}

	@Override
	public List<Computer> getComputers() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Computer> computersList = session.createQuery("from computers").list();
		for(Computer � : computersList){
			logger.info("Computer List::"+�);
		}
		return computersList;
	}

	@Override
	public Computer getComputerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Computer c = (Computer) session.load(Computer.class, new Integer(id));
		logger.info("Computer loaded successfully, Computer details="+c);
		return c;
		
	}

	@Override
	public void removeComputer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Computer c = (Computer) session.load(Computer.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Computer deleted successfully, person details="+c);
		
	}
	
}