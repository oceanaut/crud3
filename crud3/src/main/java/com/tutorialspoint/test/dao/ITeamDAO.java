package com.tutorialspoint.test.dao;

import java.util.List;

import com.tutorialspoint.test.model.Team;
//import com.tutorialspoint.test.dao.tools.Team;

public interface ITeamDAO {
	public void addTeam(Team team);  
    public void updateTeam(Team team); 
    public void deleteTeam(int id);
    public Team getTeam(int id); 
    public List<Team> getTeamById(String teamid); 
    public List<Team> getTeams();  

}
