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
		model = new Model();
	}
	/**
	 * Dodje timove u fajl uz pomoc metode klase BasketballModel
	 * @return void
	 */
	public void addTeam(Team t){
		
		model.getBasket_model().addTeam(t);
		model.updateFile();
	}
	/**
	 * Iscitava basketballModel iz fajla uz pomoc metode klase Model
	 * @return void
	 */
	public void readModel(){
		
		model.readFile();
		
	}
	/**
	 * Dodaje igraca u zadati tim
	 * @param teamName ima tima u koji se dodaje
	 * @param p igrac
	 */
	public void addPlayerCont(String teamName, Player p){
		
		model.getBasket_model().addPlayer(p, teamName);
		model.updateFile();
	}
	public void addGameCont(String game_id,String home,String away,String date,String place){
		
		model.getBasket_model().addGame(game_id, home, away, date, place);
		model.updateFile();
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
}
