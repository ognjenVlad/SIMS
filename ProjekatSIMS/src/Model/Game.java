package Model;

import java.util.Date;

public class Game {
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
	
	
	
}
