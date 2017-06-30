package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

import Model.Stat.TypeEnum;
import Model.TeamStat.TeamTypeEnum;

public class Team implements Serializable{
	HashMap<Integer,Player> team = new HashMap<Integer,Player>();
	HashMap<String,TeamStatCounter> stats = new HashMap<String,TeamStatCounter>();
	String name;
	
	public Team(String name) {
		super();
		this.name = name;
	}
	
	
	public void addGame(String game_id){
		stats.put(game_id, new TeamStatCounter());
		
		for (Entry<Integer, Player> element : team.entrySet()) {
			element.getValue().addGame(game_id);
		}
	}
	
	public void addStat(String game_id,String add_what,int amount , int quart){
		QuarterEnum quarter = getQuarterEnumVal(quart);
		TeamTypeEnum type = getTeamTypeEnumVal(add_what);
		
		for(int i = 0 ; i < amount ; i++){
			stats.get(game_id).addStat(type, quarter);
		}
	}
	
	public int countStat(String game_id,String count_what,int quart){
		QuarterEnum quarter = getQuarterEnumVal(quart);
		TeamTypeEnum type = getTeamTypeEnumVal(count_what);
		return stats.get(game_id).countStats(type,quarter);
	}
	
	public int countStat(String game_id,String count_what){
		TeamTypeEnum type = getTeamTypeEnumVal(count_what);
		return stats.get(game_id).countStats(type);
	}
	
	
	private QuarterEnum getQuarterEnumVal(int i){
		switch(i){
		case 1: return QuarterEnum.FIRST;
		case 2: return QuarterEnum.SECOND;
		case 3: return QuarterEnum.THIRD;
		case 4: return QuarterEnum.FOURTH;
		}
		return QuarterEnum.NONE;
	}


	private TeamTypeEnum getTeamTypeEnumVal(String str){
		// Possible enum values for strings
		if(str.equals("eight_seconds"))
			return TeamTypeEnum.EIGHT_SECONDS;
		else if(str.equals("five_seconds"))
			return TeamTypeEnum.FIVE_SECONDS;
		else if(str.equals("timeout"))
			return TeamTypeEnum.TIMEOUT;
		else if(str.equals("trainer_technical"))
			return TeamTypeEnum.TRAINER_TECHICAL;
		else if(str.equals("twotree_seconds"))
			return TeamTypeEnum.TWOTREE_SECONDS;
		return TeamTypeEnum.NONE;
	}

	
	
	
	
	
	
	
	
	public HashMap<Integer, Player> getTeam() {
		return team;
	}
	public void setTeam(HashMap<Integer, Player> team) {
		this.team = team;
	}
	public HashMap<String,TeamStatCounter> getStats() {
		return stats;
	}
	public void setStats(HashMap<String,TeamStatCounter> stats) {
		this.stats = stats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addPlayer(Player p){
		
		team.put(p.getDress_num(), p);
	}
	
	
}	
