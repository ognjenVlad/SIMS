package View;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	public boolean filled() {
		if (this.teamName.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	/*
	 * Poziva metodu kontrolera koji se nalazi u View
	 * i dodaje tim u fajl, kasnije treba popuniti igrace tima i statistiku
	 * @see 
	 */
	@Override
	public void actionPerformed(ActionEvent event){
		if(!filled()){
			JOptionPane.showMessageDialog(this, "Team name input is empty!");
			return;
		}
		if(this.window.getControler().ifTeamExists(this.teamName.getText())){
			JOptionPane.showMessageDialog(this, "Team name already exists!");
			return;
		}
		this.window.getControler().processAddTeam(this.teamName.getText());
		this.dispose();
		
	}
}
