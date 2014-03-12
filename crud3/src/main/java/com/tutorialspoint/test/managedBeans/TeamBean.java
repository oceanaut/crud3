package com.tutorialspoint.test.managedBeans;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
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




import com.tutorialspoint.test.model.Team;
//import com.tutorialspoint.test.dao.tools.Team;
import com.tutorialspoint.test.service.ITeamService;


@Component
@ManagedBean
@SessionScoped
//RequestScoped
//@ManagedBean(name="employeeBean")
public class TeamBean implements Serializable {

	@Autowired
	ITeamService teamService;
	List<Team> teamList;


	private int id;
	private String name;
	private int rating;
	private String selectedName;
	 
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
	   
    

	    
	    
	
    	public void generateReport() throws Exception {
    		
    		InputStream inputStream = new FileInputStream ("test_jasper.jrxml");
    		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(teamList);
    		Map parameters = new HashMap();        	
        	JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        	JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        	
        	// 4- export to word file
        	JRDocxExporter exporter1 = new JRDocxExporter();
        	exporter1.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
           	exporter1.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "c:/Downloads/ciroot/reports/test_jasper.docx" );
        	exporter1.exportReport(); 
		} 


		// CRUD operations
       //get all teams data from database
	    public List<Team> getTeamList() {
	    	teamList = new ArrayList<Team>();
	    	teamList.addAll(getTeamService().getTeams());	    	
			//List<Team> teamList=teamService.getTeams();
	            return teamList;
		}

	
	  
			
	    public void setTeamList(List<Team> teamList) {
			this.teamList = teamList;
		}




		public String saveTeam() {
		
		    
		    try {
		    	Team team=new Team();
	         	team.setName(getName());
		    	team.setRating(getRating());
	            teamService.addTeam(team);
	            resetForm();
	            return SUCCESS;
	        } catch (DataAccessException e) {
	            e.printStackTrace();
	        }  
	 
	        return ERROR;
		    	      
		 }
	    
	    public String deleteTeam() {
	    
	    	 try {
			        teamService.deleteTeam(id); 
		            return SUCCESS;
		        } catch (DataAccessException e) {
		            e.printStackTrace();
		        }  
	    	 	
		        return ERROR;
	    }
	    
	    
	    
	    public void resetForm(){
	    	setName("");
			setRating(0);	    	
	    }
	    
      
	    public void fullInfo() {
	    	
	    	//List<Team> lc = dao.getTeamById(selectedName);
	    	List<Team> lc = teamService.getTeamById(selectedName);  
	    	System.out.println("*****************************************************************************************************");
	    	//System.out.println(lc.get(0).id);
	    	System.out.println(this.id=lc.get(0).getId());
	     	System.out.println("*****************************************************************************************************");
	    	this.id=lc.get(0).getId();
	     	//this.id=lc.get(0).id;
	    	this.name=lc.get(0).getName();
	    	this.rating=lc.get(0).getRating();
	    	  /*
	    CustomerDao dao = new CustomerDao();
        List<Customer> lc = dao.getCustomerById(selectedname);
        System.out.println(lc.get(0).firstName);
        this.custId = lc.get(0).custId;
        this.firstName = lc.get(0).firstName;
        this.lastName = lc.get(0).lastName;
        this.email = lc.get(0).email;
        this.dob = lc.get(0).dob;
        this.sd = sdf.format(dob);	  
        	*/      
	    }
	
		// fields' setters getters
	    
	    
	     public TeamBean() {
	 		
	 		 }

	 		public TeamBean(String name, int rating) {		
	 		this.name = name;
	 		this.rating = rating;
	 		}
	 		
	 	    public ITeamService getTeamService() {
	 			return teamService;
	 		}




	 		public void setTeamService(ITeamService teamService) {
	 			this.teamService = teamService;
	 		}




	 		public int getId() {
	 			return id;
	 		}




	 		public void setId(int id) {
	 			this.id = id;
	 		}




	 		public String getName() {
	 			return name;
	 		}




	 		public void setName(String name) {
	 			this.name = name;
	 		}




	 		 public int getRating() {
				return rating;
			}




			public void setRating(int rating) {
				this.rating = rating;
			}




			public String getSelectedName() {
				return selectedName;
			}




			public void setSelectedName(String selectedName) {
				this.selectedName = selectedName;
			}




		
}
