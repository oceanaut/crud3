package com.tutorialspoint.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorialspoint.test.dao.ITeamDAO;
import com.tutorialspoint.test.model.Team;
//import com.tutorialspoint.test.dao.tools.Team;

@Service  
@Transactional 
public class TeamServiceImpl implements ITeamService {
	
	
	 @Autowired  
	 private ITeamDAO teamDAO;  
	  
	 
	 
	@Override
	public void addTeam(Team team) {
		// TODO Auto-generated method stub
		 teamDAO.addTeam(team); 
		
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		teamDAO.updateTeam(team); 
		
	}

	@Override
	public Team getTeam(int id) {
		// TODO Auto-generated method stub
		 return teamDAO.getTeam(id);
	}

	@Override
	public void deleteTeam(int id) {
		// TODO Auto-generated method stub
		teamDAO.deleteTeam(id);  
		
	}

	@Override
	public List<Team> getTeams() {
		// TODO Auto-generated method stub
		 return teamDAO.getTeams(); 
	}

	@Override
	public List<Team> getTeamById(String teamid) {
		// TODO Auto-generated method stub
		return teamDAO.getTeamById(teamid);
		
	}

}
