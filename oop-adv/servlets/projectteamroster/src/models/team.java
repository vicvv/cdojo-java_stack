

package models;

import java.util.ArrayList;

public class team {
	
	private String teamName;
    private static ArrayList<team> teams = new ArrayList<team>();	
	private ArrayList<player> players = new ArrayList<player>(); 
	
	public team() {
	
	}
	
	public team(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return this.teamName;
	}
	
	public ArrayList<player> getPlayers(){
		return players;
	}
	
	public static void addTeam(String teamName) {
		team newteam = new team(teamName);
		team.teams.add(newteam);
	}
	
	public void removeTeam(int index) {
		team.teams.remove(index);
	}
	
	public void addPlayer(String fname, String lname, Integer age) {
		player newplayer = new player(fname, lname, age);
		this.players.add(newplayer);
	}
	
	public static ArrayList<team> getTeams(){
		return team.teams;
	}
	
	
	

}
