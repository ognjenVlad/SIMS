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

public class TeamDialog extends JDialog implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private View view;
	private JComboBox<String> teamsCb;
	private JPanel jp;
	private JButton showTeam;
	private TeamOutputView teamView;
	
	public TeamDialog(View v) {
		super(v, "Team stats");
		this.view = v;
		init();
		showTeam.addActionListener(this);
		
		this.pack();
		this.setLocationRelativeTo(v);
	}
	public void init(){
		this.jp = new JPanel(new GridLayout(5, 2));
		createComboBox();
		showTeam = new JButton("Show team");
		jp.add(Box.createHorizontalStrut(30));
		jp.add(Box.createHorizontalStrut(30));
		
		jp.add(new JLabel("Team: "));
		jp.add(this.teamsCb);
		
		jp.add(Box.createHorizontalStrut(30));
		jp.add(Box.createHorizontalStrut(30));
		jp.add(showTeam);
		
		this.add(jp);
		
	}
	public void createComboBox(){
		this.teamsCb = new JComboBox<String>();
		for(String s: this.view.getControler().getTeamNames()){
			this.teamsCb.addItem(s);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		teamView = new TeamOutputView(view,teamsCb.getSelectedItem().toString());
		teamView.setVisible(true);
		this.dispose();

	}

}
