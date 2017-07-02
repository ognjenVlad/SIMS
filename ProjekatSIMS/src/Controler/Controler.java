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
		for(Team t:this.model.getBasketModel().getTeams().values()){
			teams.add(t.getName());
		}
		return teams;
	}
	
	public ArrayList<String> getPlayersSorter(String team){
		return model.getPlayersSorter(team);
	}
	
	public void processAddPoints(String game_id ,String team_name,int jersey,int shot_for,int total 
			, int good , int pos , int quart){
		model.addPoints(game_id, team_name, jersey, shot_for, total, good, pos, quart);;
	}
	
	public void processAddStat(String game_id ,String team_name,int jersey
			,String add_what,int amount,int quart){
		model.addStat(game_id, team_name, jersey, add_what, amount, quart);
	}


	
}
