package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private View v; 
	
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
		
		JPanel jp = new JPanel(new GridLayout(6, 2));
		jp.add(numStr);
		jp.add(playerNum);
		
		jp.add(nameStr);
		jp.add(playerName);
		
		jp.add(surStr);
		jp.add(playerSur);
		createComboBox();
		jp.add(new JLabel("Team: "));
		jp.add(this.teamsCb);
		
		jp.add(Box.createHorizontalStrut(30));
		jp.add(Box.createHorizontalStrut(30));
		jp.add(Box.createHorizontalStrut(30));
		addPlayerButton = new JButton("Add player");
		addPlayerButton.addActionListener(this);
		jp.add(addPlayerButton);
		
		this.add(jp);
	}
	
	void createComboBox(){
		this.teamsCb = new JComboBox<String>();
		for(String s: v.getControler().getTeamNames()){
			this.teamsCb.addItem(s);
		}
	}
	@Override
	public void actionPerformed(ActionEvent event){
		
		v.getControler().processAddPlayer(Integer.parseInt(this.playerNum.getText()),this.playerName.getText(),this.playerSur.getText(),teamsCb.getSelectedItem().toString());
		this.dispose();
	}
}
