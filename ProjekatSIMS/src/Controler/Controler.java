package Controler;

import java.util.ArrayList;

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
	public ArrayList<Team> readTeams(){
		
		teams.readTeams();
		ArrayList<Team> t = teams.getTeams();
		for (Team team : t) {
			System.out.println(team.getName());
		}
		
		return t;
		
	}
}
