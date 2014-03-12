package com.tutorialspoint.test.managedBeans;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;








import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;









import com.tutorialspoint.test.model.Stock;
import com.tutorialspoint.test.model.StockDailyRecord;
import com.tutorialspoint.test.model.Team;
import com.tutorialspoint.test.service.IStockDailyService;
import com.tutorialspoint.test.service.IStockService;
//import com.tutorialspoint.test.dao.tools.Team;
import com.tutorialspoint.test.service.ITeamService;


@Component
@ManagedBean
@SessionScoped
//RequestScoped
//@ManagedBean(name="employeeBean")
public class StockBean implements Serializable {

	@Autowired
	IStockService stockService;
	IStockDailyService stockDailyService ;
	List<Team> teamList;


	private int stock_id;
	private String stock_code;
	private String stock_name;
	private Float priceOpen;
	private Float priceClose;
	private Float priceChange;
	private Long volume;
	private Date date;
	 
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
	   
    

	    
	    






		public String saveStock() {
		
		    
		    try {
		    	Stock stock = new Stock();
	         	stock.setStockCode("7052");
	         	stock.setStockName("PADINI");
	         	stockService.addStock(stock);

	         	StockDailyRecord stockDailyRecords = new StockDailyRecord();
	            stockDailyRecords.setPriceOpen(new Float("1.2"));
	            stockDailyRecords.setPriceClose(new Float("1.1"));
	            stockDailyRecords.setPriceChange(new Float("10.0"));
	            stockDailyRecords.setVolume(3000000L);
	            stockDailyRecords.setDate(new Date());
	            
	            stockDailyRecords.setStock(stock);        
	            stock.getStockDailyRecords().add(stockDailyRecords);
	          
	            return SUCCESS;
	        } catch (DataAccessException e) {
	            e.printStackTrace();
	        }  
	 
	        return ERROR;
		    	      
		 }











		public IStockService getStockService() {
			return stockService;
		}











		public void setStockService(IStockService stockService) {
			this.stockService = stockService;
		}











		public IStockDailyService getStockDailyService() {
			return stockDailyService;
		}











		public void setStockDailyService(IStockDailyService stockDailyService) {
			this.stockDailyService = stockDailyService;
		}











		public int getStock_id() {
			return stock_id;
		}











		public void setStock_id(int stock_id) {
			this.stock_id = stock_id;
		}











		public String getStock_name() {
			return stock_name;
		}











		public void setStock_name(String stock_name) {
			this.stock_name = stock_name;
		}











		public Float getPriceOpen() {
			return priceOpen;
		}











		public void setPriceOpen(Float priceOpen) {
			this.priceOpen = priceOpen;
		}











		public Float getPriceClose() {
			return priceClose;
		}











		public void setPriceClose(Float priceClose) {
			this.priceClose = priceClose;
		}











		public Float getPriceChange() {
			return priceChange;
		}











		public void setPriceChange(Float priceChange) {
			this.priceChange = priceChange;
		}











		public Long getVolume() {
			return volume;
		}











		public void setVolume(Long volume) {
			this.volume = volume;
		}











		public Date getDate() {
			return date;
		}











		public void setDate(Date date) {
			this.date = date;
		}
	        
	      
		// fields' setters getters
	    
		
	    
	 

		
}
