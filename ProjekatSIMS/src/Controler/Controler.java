package Controler;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Player;
import Model.Team;
import Model.Teams;
import View.View;

/**
 * @author Ognjen
 */
public class Controler {

	private View v;
	private Teams teams;
	
	public Controler(View view){
		this.v = view;
		teams = new Teams();
	}
	/**
	 * Dodje timove u fajl uz pomoc metode klase Teams
	 * @return void
	 */
	public void addTeam(Team t){
		
		teams.addTeam(t);
	}
	/**
	 * Iscitava timove iz fajla uz pomoc metode klase Teams
	 * @return ArrayList<Team>
	 */
	public ArrayList<Team> readTeamsCont(){
		
		teams.readTeams();
		ArrayList<Team> t = teams.getTeams();
		return t;
		
	}
	/**
	 * Dodaje igraca u zadati tim
	 * @param teamName ima tima u koji se dodaje
	 * @param p igrac
	 */
	public void addPlayerCont(String teamName, Player p){
		
		ArrayList<Team> t = teams.getTeams();
		for (Team team : t) {
			if(teamName.equals(team.getName())){
				team.addPlayer(p);
			}
		}
		teams.setTeams(t);
		teams.refreshFile();//da bi se dodati igraci sacuvali u fajl
	}
}
