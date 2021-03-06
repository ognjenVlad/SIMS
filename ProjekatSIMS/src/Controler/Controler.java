package Controler;

import java.util.ArrayList;

import Model.Game;
import Model.Model;
import Model.Player;
import Model.Team;
import View.View;

/**
 * @author Ognjen
 */
public class Controler {

	private View v;
	private Model model;

	public Controler(View view) {
		this.v = view;
		this.model = new Model();
	}

	/**
	 * Dodje timove u fajl uz pomoc metode klase BasketballModel
	 * 
	 * @return void
	 */
	public void processAddTeam(String name) {
		Team t = new Team(name);
		this.model.getBasketModel().addTeam(t);
		this.model.updateFile();
	}

	/**
	 * Iscitava basketballModel iz fajla uz pomoc metode klase Model
	 * 
	 * @return void
	 */
	public void readModel() {

		this.model.readFile();

	}

	/**
	 * Dodaje igraca u zadati tim
	 * 
	 * @param teamName
	 *            ima tima u koji se dodaje
	 * @param p
	 *            igrac
	 */
	public void processAddPlayer(int num, String name, String surname, String teamName) {
		Player p = new Player(num, name, surname);
		this.model.getBasketModel().addPlayer(p, teamName);
		this.model.updateFile();
	}

	public void processAddGame(String game_id, String home, String away, String date, String place) {

		this.model.getBasketModel().addGame(game_id, home, away, date, place);
		this.model.updateFile();
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public void updateFile(){
		this.model.updateFile();
	}

	public ArrayList<String> getTeamNames() {

		ArrayList<String> teams = new ArrayList<String>();
		for (Team t : this.model.getBasketModel().getTeams().values()) {
			teams.add(t.getName());
		}
		return teams;
	}
	/**
	 * Timovi sa 12 igraca, manje od toga ne mogu da igraju utakmicu
	 * @return
	 */
	public ArrayList<String> validTeams(){
		ArrayList<String> teams = new ArrayList<String>();
		for (Team t : this.model.getBasketModel().getTeams().values()) {
			if(t.getTeam().size() >= 12){
				teams.add(t.getName());
			}	
		}
		return teams;
	}
	/**
	 * Igrac moze da se doda samo u tim koji ima manje od 12 igraca
	 * @return
	 */
	public ArrayList<String> notFullTeams(){
		ArrayList<String> teams = new ArrayList<String>();
		for (Team t : this.model.getBasketModel().getTeams().values()) {
			if(t.getTeam().size() < 12){
				teams.add(t.getName());
			}	
		}
		return teams;
	}

	public ArrayList<String> getPlayers(String team) {

		ArrayList<String> players = new ArrayList<String>();
		Team t = this.model.getBasketModel().getTeams().get(team);
		for (Player p : t.getTeam().values()) {
			players.add(p.getDress_num() + " " + p.getName() + " " + p.getSurname());
		}
		return players;
	}

	public ArrayList<String> getGames() {
		ArrayList<String> games = new ArrayList<String>();

		for (Game g : this.model.getBasketModel().getGames().values()) {
			games.add(g.toString());
		}
		return games;
	}

	public boolean ifTeamExists(String teamName) {

		for (Team t : this.model.getBasketModel().getTeams().values()) {
			if (t.getName().toUpperCase().equals(teamName.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	public boolean ifJersyExists(String jersyNum, String teamName) {
		Team t = this.model.getBasketModel().getTeams().get(teamName);
		for (Player p : t.getTeam().values()) {
			if(p.getDress_num() == Integer.valueOf(jersyNum)){
				return true;
			}
		}
		return false;
	}
	public boolean ifGameIdExists(String id) {
		for (Game g : this.model.getBasketModel().getGames().values()){
			if(g.getGame_id().equals(id)){
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> getPlayersSorter(String team) {
		return model.getPlayersSorter(team);
	}

	public void processAddPoints(String game_id, String team_name, int jersey, int shot_for, int total, int good,
			int pos, int quart) {
		model.addPoints(game_id, team_name, jersey, shot_for, total, good, pos, quart);
		;
	}

	public void processAddStat(String game_id, String team_name, int jersey, String add_what, int amount, int quart) {
		model.addStat(game_id, team_name, jersey, add_what, amount, quart);
	}

	public void processAddTStat(String game_id, String team_name, String add_what, int amount, int quart) {
		model.addTStat(game_id, team_name, add_what, amount, quart);
	}

	public double countAvgShots(String team, int jersey, int shot_for, boolean isGood, int pos, int quart) {
		return model.countAvgShots(team, jersey, shot_for, isGood, pos, quart);
	}

	public double countAvgStat(String team, int jersey, String count_what, int quart) {
		return model.countAvgStat(team, jersey, count_what, quart);
	}

	public double countAvgTStat(String team, String count_what, int quart) {
		return model.countAvgTStat(team, count_what, quart);
	}

	public int countTStat(String game_id, String team, String count_what, int quart) {
		return model.countTStat(game_id, team, count_what, quart);
	}

	public int countShots(String game_id, String team, int jersey, int shot_for, boolean isGood, int pos, int quart) {
		return model.countShots(game_id, team, jersey, shot_for, isGood, pos, quart);
	}

	public int countStats(String game_id, String team, int jersey, String count_what, int quart) {
		return model.countStats(game_id, team, jersey, count_what, quart);
	}

}
