package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BasketballModel {
	HashMap<String,Game> games = new HashMap<String,Game>();
	ArrayList<Team> teams = new ArrayList<Team>();
	ArrayList<Player> player = new ArrayList<Player>();
	
	public void addGame(String game_id,Team home,Team away,Date date,String place){
		games.put(game_id, new Game(game_id,home,away,date,place));
	}
	
	public void addPlayer(Player p){
		player.add(p);
	}
	
	public void addTeam(Team t){
		teams.add(t);
	}
}
