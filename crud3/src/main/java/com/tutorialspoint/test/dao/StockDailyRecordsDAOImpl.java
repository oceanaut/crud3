package com.tutorialspoint.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tutorialspoint.test.model.StockDailyRecord;

public class StockDailyRecordsDAOImpl implements IStockDailyRecordsDAO {
	
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
	public void addStockDailyRecords(StockDailyRecord stockDailyRecords) {
		// TODO Auto-generated method stub
		getCurrentSession().save(stockDailyRecords); 
	}

}
