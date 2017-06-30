package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Player;
import Model.Team;

/**
 *  * Dijalog za dodavanje novog igraca
 * @author Ognjen
 */
public class PlayerWindow extends JDialog implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	private JTextField playerName;
	private JTextField playerNum;
	private JTextField playerSur;
	private JLabel numStr;
	private JLabel nameStr;
	private JLabel surStr;
	private JComboBox<String> teamsCb;//combobox za izbor timova
	private JButton addPlayerButton;
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
		jp.add(playerNum);
		
		jp.add(nameStr);
		jp.add(playerName);
		
		jp.add(surStr);
		jp.add(playerSur);
		createComboBox();
		
		jp.add(this.teamsCb);
		
		addPlayerButton = new JButton("Add player");
		addPlayerButton.addActionListener(this);
		jp.add(addPlayerButton);
		
		this.add(jp);
	}
	
	void createComboBox(){
		this.teamsCb = new JComboBox<String>();
		for(Team t: v.controler.readTeamsCont()){
			System.out.println(t.getName());
			this.teamsCb.addItem(t.getName());
		}
	}
	@Override
	public void actionPerformed(ActionEvent event){
		Player p = new Player(Integer.parseInt(this.playerNum.getText()),this.playerName.getText(),this.playerSur.getText());
		v.controler.addPlayerCont(teamsCb.getSelectedItem().toString(), p);
		this.dispose();
	}
}
