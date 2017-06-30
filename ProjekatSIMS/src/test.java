import java.util.ArrayList;

import Controler.Controler;
import Model.Player;
import Model.Team;
import View.View;

public class test {

	public static void main(String[] args) {
		
		/*
		
		How to use model START

		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Team> teams = new ArrayList<Team>();
		
		players.add(new Player(4,"Ogisa0","Ogisa0"));
		players.add(new Player(5,"Ogisa1","Ogisa1"));
		players.add(new Player(15,"Ogisa2","Ogisa2"));
		players.add(new Player(14,"Ogisa3","Ogisa3"));
		
		teams.add(new Team("Fener"));

		teams.get(0).addPlayer(players.get(0));
		teams.get(0).addPlayer(players.get(1));
		teams.get(0).addPlayer(players.get(2));
		teams.get(0).addPlayer(players.get(3));

		teams.get(0).addGame("13");
		teams.get(0).addStat("13", "timeout" , 10, 1);
		teams.get(0).addStat("13", "eight_seconds" , 5 , 2);
		players.get(0).addShots("13", 2, 10, 5, 2, 1);
		players.get(0).addShots("13", 2, 5, 5, 2, 2);
		
		int shotsMade = players.get(0).countShots("13", 2, true, 2,2) + players.get(0).countShots("13", 2, true, 2,1);
		int shotsMissed = players.get(0).countShots("13", 2, false, 2,2) + players.get(0).countShots("13", 2, false, 2,1);
		int totalShots = shotsMade + shotsMissed;
		System.out.println("Player " + players.get(0).getDress_num() + 
				" hit in 2. quarter for 2 points:" + shotsMade + " / " + totalShots);
		System.out.println("Timeouts total:" + teams.get(0).countStat("13", "timeout"));
		System.out.println("Eight seconds 1. quarter" + teams.get(0).countStat("13", "eight_seconds",1));
		System.out.println("Eight seconds 2. quarter" + teams.get(0).countStat("13", "eight_seconds",2));

		How to use model END
		*/
		
		View v = new View();
		Controler c = new Controler(v);
		v.setControler(c);
		v.setVisible(true);

	}

}
