package com.tutorialspoint.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorialspoint.test.model.Team;
//import com.tutorialspoint.test.dao.tools.Team;

@Repository  
public class TeamDAOImpl implements ITeamDAO {

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
	public void addTeam(Team team) {
		// TODO Auto-generated method stub
		 getCurrentSession().save(team);  
		
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		   Team teamToUpdate = getTeam(team.getId());  
	        teamToUpdate.setName(team.getName());  
	        teamToUpdate.setRating(team.getRating());  
	        getCurrentSession().update(teamToUpdate);
		
	}

	@Override
	public void deleteTeam(int id) {
		// TODO Auto-generated method stub
		Team team = getTeam(id);  
        if (team != null)  
            getCurrentSession().delete(team);
		
	}
	
	@Override
	public Team getTeam(int id) {
		// TODO Auto-generated method stub
		Team team = (Team) getCurrentSession().get(Team.class, id);  
        return team;  
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> getTeams() {
		
		// TODO Auto-generated method stub
		 //List<Team> users = new ArrayList<Team>();
		//users=getCurrentSession().createQuery("from Team").list(); 
		//return users;
		return getCurrentSession().createQuery("from Team").list();
	}

	@Override
	public List<Team> getTeamById(String teamid) {
		// TODO Auto-generated method stub
		//getCurrentSession().createQuery("from Team where concat(name, ' ', rayting) = :id").setString("id", teamid);
		String queryString = "from Team where concat(name, ' ', rayting) = :id";
		Query query = getCurrentSession().createQuery(queryString);
		query.setString("id", teamid);
		
		List<Team> list = query.list();
        if (list.size() > 0) {
            return list;
        }
		
        return null;
	}
	
	

}
