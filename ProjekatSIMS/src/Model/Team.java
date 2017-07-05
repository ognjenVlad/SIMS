package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import Model.TeamStat.TeamTypeEnum;

public class Team implements Serializable{
	HashMap<Integer,Player> players = new HashMap<Integer,Player>();
	HashMap<String,TeamStatCounter> stats = new HashMap<String,TeamStatCounter>();
	String name;
	
	public Team(String name) {
		super();
		this.name = name;
	}
	
	public void addGame(String game_id){
		stats.put(game_id, new TeamStatCounter());
		
		for (Entry<Integer, Player> element : players.entrySet()) {
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
		if(quart==0) {
			return countStat(game_id, count_what);
		}
		QuarterEnum quarter = getQuarterEnumVal(quart);
		TeamTypeEnum type = getTeamTypeEnumVal(count_what);
		return stats.get(game_id).countStats(type,quarter);
	}
	
	public int countStat(String game_id,String count_what){
		TeamTypeEnum type = getTeamTypeEnumVal(count_what);
		return stats.get(game_id).countStats(type);
	}
	
	public double countAvgShots(int jersey,int shot_for,boolean isGood,int pos,int quart) {
		return players.get(jersey).countAvgShots(shot_for, isGood, pos,quart);
	}
	
	public double countAvgStat(int jersey,String count_what,int quart) {
		return players.get(jersey).countAvgStat(count_what, quart);
	}
	
	public double countAvgTStat(String count_what,int quart) {
		if(quart == 0) {
			this.countAvgTStat(count_what);
		}
		double count = 0;
		for (String key : stats.keySet()) {
			count += this.countStat(key,count_what,quart);			
		}
		
		return count;
	}
	
	public double countAvgTStat(String count_what) {
		double count = 0;
		for (String key : stats.keySet()) {
			count += this.countStat(key,count_what);			
		}
		
		return count;
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
		else if(str.equals("twothree_seconds"))
			return TeamTypeEnum.TWOFOUR_SECONDS;
		return TeamTypeEnum.NONE;
	}
	
	public HashMap<Integer, Player> getTeam() {
		return players;
	}
	public void setTeam(HashMap<Integer, Player> players) {
		this.players = players;
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
		
		players.put(p.getDress_num(), p);
	}
	
	public Player getPlayer(int jersey){
		return players.get(jersey);
	}
	
	public ArrayList<Integer> getPlayersSorted(){
		ArrayList<Integer> sorted_players =  new ArrayList(players.keySet());
		Collections.sort(sorted_players);
		return sorted_players;
	}


	@Override
	public String toString() {
		return name;
	}
	
	
}	
