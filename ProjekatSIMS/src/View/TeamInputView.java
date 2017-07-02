package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TeamInputView extends JDialog implements ActionListener{
	View view;
	JTabbedPane tabbedPane;
	JButton saveButton;
	
	String game_id;
	String team1;
	String team2;
	
	
	TeamInputView(View v,String game_id,String team1,String team2){
		this.game_id = game_id;
		this.team1 = team1;
		this.team2 = team2;
		
		this.view = v;
		
		this.tabbedPane = new JTabbedPane();
		this.saveButton = new JButton("Save");
		this.setSize(500,500);
		this.setLocationRelativeTo(v);
		this.setModal(true);
		
		init();
	}
	
	
	private void init() {
		
		
		this.add(this.tabbedPane);
		this.add(saveButton,BorderLayout.SOUTH);
		
		this.tabbedPane.add(new TeamInputTab(view,game_id,team1),team1);
		this.tabbedPane.add(new TeamInputTab(view,game_id,team2),team2);

		this.tabbedPane.setVisible(true);
}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
