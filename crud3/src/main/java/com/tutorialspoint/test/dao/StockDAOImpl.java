package com.tutorialspoint.test.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorialspoint.test.model.Stock;
import com.tutorialspoint.test.model.StockDailyRecord;

@Repository
public class StockDAOImpl implements IStockDAO {

	
	@Autowired  
    private SessionFactory sessionFactory;  
	
		
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	 private Session getCurrentSession() {  
	        return sessionFactory.getCurrentSession();  
	    } 
	 
	 
	 
	@Override
	public void addStock(Stock stock) {
		// TODO Auto-generated method stub
		 getCurrentSession().save(stock); 

	}


	
}
