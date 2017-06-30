package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Klasa sadrzi metode za citanje iz fajla i dodavanje timova u fajl
 * 	teams - lista timova
 * @author Ognjen
 *
 *
 */
public class Teams {
	ArrayList<Team> teams = new ArrayList<Team>(); 
	ObjectOutputStream os;
	ObjectInputStream is;
	public Teams(){
		readTeams();
	}
	public void addTeam(Team t){
		
		try {
			os = new ObjectOutputStream(new FileOutputStream("./resources/teams.app"));
			teams.add(t);
			os.writeObject(teams);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Upisuje celu listu u fajl ako je doslo do promene(npr. dodavanje igraca)
	 */
	public void refreshFile(){
		try {
			os = new ObjectOutputStream(new FileOutputStream("./resources/teams.app"));
			os.writeObject(teams);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void readTeams(){
		
		try {
			is = new ObjectInputStream(new FileInputStream("./resources/teams.app"));
			
			teams =  (ArrayList<Team>) is.readObject();
			is.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
}
