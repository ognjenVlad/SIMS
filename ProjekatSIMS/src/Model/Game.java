package Model;

import java.io.Serializable;
import java.util.Date;

public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Team homeTeam;
	Team awayTeam;
	String game_id;
	Date date;
	String place;
	
	
	public Game(String game_id,Team homeTeam, Team awayTeam, Date date, String place) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.game_id = game_id;
		this.date = date;
		this.place = place;
		
		homeTeam.addGame(game_id);
		awayTeam.addGame(game_id);
	}


	@Override
	public String toString() {
		return game_id + " : " + homeTeam + " vs " + awayTeam;
	}
	
	public Team getTeam(String team_name){
		if(team_name.equals(homeTeam.getName())){
			return homeTeam;
		}else if(team_name.equals(awayTeam.getName())){
			return awayTeam;
		}
		
		return null;
	}
	
	
	
}
