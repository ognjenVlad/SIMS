package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Team;

/**
 *  * Dijalog za dodavanje novog igraca
 * @author Ognjen
 */
public class PlayerWindow extends JDialog {
	

	private static final long serialVersionUID = 1L;
	private JTextField playerName;
	private JTextField playerNum;
	private JTextField playerSur;
	private JLabel numStr;
	private JLabel nameStr;
	private JLabel surStr;
	private JComboBox<String> teams;//combobox za izbor timova
	private JButton addTeamButton;
	View v; 
	
	public PlayerWindow(View v) {
		super(v, "Add player");
		this.v = v;
		init();
		
		this.pack();
		this.setLocationRelativeTo(v);
	}
	public void init(){
		playerName = new JTextField();
		playerSur = new JTextField();
		playerNum = new JTextField();
		numStr = new JLabel("Player number: ");
		
		nameStr = new JLabel("Player name: ");
		
		surStr = new JLabel("Player surname: ");
		
		JPanel jp = new JPanel(new GridLayout(5, 2));
		jp.add(numStr);
		jp.add(playerName);
		
		jp.add(nameStr);
		jp.add(playerSur);
		
		jp.add(surStr);
		jp.add(playerNum);
		createComboBox();
		
		jp.add(this.teams);
		
		addTeamButton = new JButton("Add player");
		jp.add(addTeamButton);
		
		this.add(jp);
	}
	
	void createComboBox(){
		this.teams = new JComboBox<String>();
		for(Team t: v.controler.readTeams()){
			System.out.println(t.getName());
			this.teams.addItem(t.getName());
		}
	}
}
