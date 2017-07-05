package Model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Model.TeamStat.TeamTypeEnum;

public class BasketballModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashMap<String,Game> games = new HashMap<String,Game>();
	private HashMap<String,Team> teams = new HashMap<String,Team>();
	private ArrayList<Player> players = new ArrayList<Player>();
	
	
	public void addGame(String game_id,String home,String away,String date,String place){
		Date dat;
		try {
			dat = new SimpleDateFormat("dd.MM.yyyy").parse(date);
		} catch (ParseException e) {
			dat = null;
			e.printStackTrace();
		}
		Team homeTeam = findTeam(home);
		Team awayTeam = findTeam(away);
		games.put(game_id, new Game(game_id,homeTeam,awayTeam,dat,place));
	}
	
	public void addPlayer(Player p, String teamName){
		players.add(p);
		teams.get(teamName).addPlayer(p);
	}
	
	public void addTeam(Team t){
		teams.put(t.getName(),t);
	}
	public Team findTeam(String team){
		return teams.get(team);
	}
	
	public HashMap<String, Game> getGames() {
		return games;
	}

	public void setGames(HashMap<String, Game> games) {
		this.games = games;
	}

	public HashMap<String,Team> getTeams() {
		return teams;
	}

	public void setTeams(HashMap<String,Team> teams) {
		this.teams = teams;
	}

	public ArrayList<Player> getPlayer() {
		return players;
	}

	public void setPlayer(ArrayList<Player> player) {
		this.players = player;
	}
	
	public void addPoints(String game_id ,String team_name,int jersey,int shot_for,int total 
			, int good , int pos , int quart){
		games.get(game_id).getTeam(team_name).getPlayer(jersey)
		.addShots(game_id, shot_for, total, good, pos, quart);
	}
	
	public void addStat(String game_id ,String team_name,int jersey
			,String add_what,int amount,int quart){
		games.get(game_id).getTeam(team_name).getPlayer(jersey)
		.addStats(game_id, add_what, amount, quart);
		
	}
	
	public ArrayList<String> getPlayersSorter(String team){
		ArrayList<Integer> players = teams.get(team).getPlayersSorted();
		ArrayList<String> ret_value = new ArrayList<String>();
		String name , surname ;
		int jersey;

		for (Integer integer : players) {
			surname = teams.get(team).getPlayer(integer).getSurname();
			name = teams.get(team).getPlayer(integer).getName();
			jersey = teams.get(team).getPlayer(integer).getDress_num();
			ret_value.add(jersey+", "+name + " " + surname);
		}
		
		return ret_value;
	}
	
	public void addTStat(String game_id,String team_name,String add_what,int amount,int quart) {
		teams.get(team_name).addStat(game_id,add_what,amount,quart);
	}

	public double countAvgShots(String team,int jersey,int shot_for,boolean isGood,int pos,int quart) {
		return  teams.get(team).countAvgShots(jersey,shot_for, isGood, pos,quart);
	}
	
	public double countAvgStat(String team,int jersey,String count_what,int quart) {
		return teams.get(team).countAvgStat(jersey,count_what, quart);
	}
	
	public double countAvgTStat(String team,String count_what,int quart) {
		return teams.get(team).countAvgTStat(count_what, quart);
	}
	
	public int countTStat(String game_id,String team,String count_what,int quart){
		return teams.get(team).countStat(game_id,count_what,quart);
	}
	
	public int countShots(String game_id,String team,int jersey,int shot_for,boolean isGood,int pos,int quart){
		return teams.get(team).getPlayer(jersey).countShots(game_id,shot_for,isGood,pos,quart);
	}

	public int countStats(String game_id,String team,int jersey,String count_what,int quart){
		return teams.get(team).getPlayer(jersey).countStat(game_id, count_what,quart);
	}

	
}
