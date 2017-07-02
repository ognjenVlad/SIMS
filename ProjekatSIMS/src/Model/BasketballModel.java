package Model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BasketballModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashMap<String,Game> games = new HashMap<String,Game>();
	private ArrayList<Team> teams = new ArrayList<Team>();
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
		for (Team team : this.getTeams() ) {
			if(teamName.equals(team.getName())){
				team.addPlayer(p);
			}
		}
	}
	
	public void addTeam(Team t){
		teams.add(t);
	}
	public Team findTeam(String team){
		for (Team t : teams) {
			if(t.getName().equals(team)){
				return t;
			}
		}
		return null;
	}
	public HashMap<String, Game> getGames() {
		return games;
	}

	public void setGames(HashMap<String, Game> games) {
		this.games = games;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public ArrayList<Player> getPlayer() {
		return players;
	}

	public void setPlayer(ArrayList<Player> player) {
		this.players = player;
	}
	
	
}
