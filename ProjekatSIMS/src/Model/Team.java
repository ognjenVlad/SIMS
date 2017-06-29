package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Team implements Serializable{
	HashMap<Integer,Player> team = new HashMap<Integer,Player>();
	ArrayList<TeamStat> stats = new ArrayList<TeamStat>();
	String name;
	public Team(String name) {
		super();
		this.name = name;
	}
	public HashMap<Integer, Player> getTeam() {
		return team;
	}
	public void setTeam(HashMap<Integer, Player> team) {
		this.team = team;
	}
	public ArrayList<TeamStat> getStats() {
		return stats;
	}
	public void setStats(ArrayList<TeamStat> stats) {
		this.stats = stats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}	
