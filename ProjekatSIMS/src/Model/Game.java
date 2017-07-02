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
		return "Game [homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", game_id=" + game_id + ", date=" + date
				+ ", place=" + place + "]";
	}
	
	
	
}
