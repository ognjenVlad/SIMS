package Controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Model.Model;
import Model.Player;
import Model.Team;
import Model.Teams;
import View.View;

/**
 * @author Ognjen
 */
public class Controler {

	private View v;
	private Model model;
	
	public Controler(View view){
		this.v = view;
		this.model = new Model();
	}
	/**
	 * Dodje timove u fajl uz pomoc metode klase BasketballModel
	 * @return void
	 */
	public void processAddTeam(String name){
		Team t = new Team(name);
		this.model.getBasketModel().addTeam(t);
		this.model.updateFile();
	}
	/**
	 * Iscitava basketballModel iz fajla uz pomoc metode klase Model
	 * @return void
	 */
	public void readModel(){
		
		this.model.readFile();
		
	}
	/**
	 * Dodaje igraca u zadati tim
	 * @param teamName ima tima u koji se dodaje
	 * @param p igrac
	 */
	public void processAddPlayer(int num,String name, String surname, String teamName){
		Player p = new Player(num, name, surname);
		this.model.getBasketModel().addPlayer(p, teamName);
		this.model.updateFile();
	}
	public void processAddGame(String game_id,String home,String away,String date,String place){
		
		this.model.getBasketModel().addGame(game_id, home, away, date, place);
		this.model.updateFile();
	}

	public void setModel(Model model) {
		this.model = model;
	}
	public ArrayList<String> getTeamNames(){
		
		ArrayList<String> teams = new ArrayList<String>();
		for(Team t:this.model.getBasketModel().getTeams()){
			teams.add(t.getName());
		}
		return teams;
	}
	
}
