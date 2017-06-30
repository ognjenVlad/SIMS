package View;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Team;

/**
 * Dijalog za dodavanje novog tima
 * @author Ogauzz
 *
 */
public class TeamWindow extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTextField teamName;
	private JLabel nameStr;
	private JButton addTeamButton;
	View window;
	TeamWindow(View v){
		super(v, "Add team");
		teamName = new JTextField();
		nameStr = new JLabel("Team name: ");
		window = v;
		
		this.addTeamButton = new JButton("Add team");
		this.addTeamButton.addActionListener(this);
		
		JPanel text = new JPanel(new GridLayout(1, 2));
		text.add(nameStr);
		text.add(teamName);
		
		JPanel jp = new JPanel(new GridLayout(3, 1));
		jp.add(text);
		jp.add(Box.createHorizontalStrut(30));
		jp.add(addTeamButton);
		this.add(jp);
		this.pack();
		this.setLocationRelativeTo(v);
		this.setVisible(true);
	}
	/*
	 * Poziva metodu kontrolera koji se nalazi u View
	 * i dodaje tim u fajl, kasnije treba popuniti igrace tima i statistiku
	 * @see 
	 */
	@Override
	public void actionPerformed(ActionEvent event){
		Team t = new Team(this.teamName.getText());
		window.getControler().addTeam(t);
		this.dispose();
		
	}
}
