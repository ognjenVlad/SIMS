import Controler.Controler;
import View.View;

public class test {

	public static void main(String[] args) {
		
		View v = new View();
		Controler c = new Controler(v);
		


		/*		
		c.processAddTeam("team1");
		c.processAddTeam("team2");

		c.processAddPlayer(1, "a", "a", "team1");
		c.processAddPlayer(2, "a", "a", "team1");
		c.processAddPlayer(3, "a", "a", "team1");
		c.processAddPlayer(4, "a", "a", "team1");
		c.processAddPlayer(5, "a", "a", "team1");
		c.processAddPlayer(6, "a", "a", "team1");
		c.processAddPlayer(7, "a", "a", "team1");
		c.processAddPlayer(8, "a", "a", "team1");
		c.processAddPlayer(9, "a", "a", "team1");
		c.processAddPlayer(10, "a", "a", "team1");
		c.processAddPlayer(11, "a", "a", "team1");
		c.processAddPlayer(12, "a", "a", "team1");

		c.processAddPlayer(1, "a", "a", "team2");
		c.processAddPlayer(2, "a", "a", "team2");
		c.processAddPlayer(3, "a", "a", "team2");
		c.processAddPlayer(4, "a", "a", "team2");
		c.processAddPlayer(5, "a", "a", "team2");
		c.processAddPlayer(6, "a", "a", "team2");
		c.processAddPlayer(7, "a", "a", "team2");
		c.processAddPlayer(8, "a", "a", "team2");
		c.processAddPlayer(9, "a", "a", "team2");
		c.processAddPlayer(10, "a", "a", "team2");
		c.processAddPlayer(11, "a", "a", "team2");
		c.processAddPlayer(12, "a", "a", "team2");

		c.processAddGame("33", "team1", "team2", "12.12.2015", "Subotica");
		c.processAddGame("34", "team1", "team2", "12.12.2015", "Subotica");
		
		c.processAddPoints("33", "team1", 1, 2, 5, 3, 2, 1);
		c.processAddPoints("34", "team1", 1, 2, 5, 5, 2, 1);
		c.processAddGame("35", "team1", "team2", "12.12.2015", "Subotica");
		c.processAddPoints("35", "team1", 1, 2, 5, 3, 2, 3);
		System.out.println("Total " + c.countAvgShots("team1", 1, 2, true, 2, 0));
		System.out.println("Quart 1 " + c.countAvgShots("team1", 1, 2, true, 2, 1));
		System.out.println("Quart 2 " + c.countAvgShots("team1", 1, 2, true, 2, 2));

		c.updateFile();

		*/
		
		
		
		v.setControler(c);
		v.setVisible(true);

	}

}
