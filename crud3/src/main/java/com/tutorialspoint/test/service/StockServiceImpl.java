package com.tutorialspoint.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorialspoint.test.dao.IStockDAO;
import com.tutorialspoint.test.model.Stock;
import com.tutorialspoint.test.model.StockDailyRecord;


@Service  
@Transactional 
public class StockServiceImpl implements IStockService {
	
	
	 @Autowired  
	 private IStockDAO stockDAO;  
	 

	@Override
	public void addStock(Stock stock) {
		// TODO Auto-generated method stub
		stockDAO.addStock(stock);
	

	}

}
