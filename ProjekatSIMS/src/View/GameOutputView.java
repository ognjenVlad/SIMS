package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;

public class GameOutputView extends JDialog implements ActionListener{
	JTabbedPane tabbedPane;
	JButton backButton;
	
	View view;
	String game_id;
	String team1;
	String team2;
	
	GameOutputView(View v,String game_id,String team1,String team2){
		super(v, "Game view");
		this.game_id = game_id;
		this.team1 = team1;
		this.team2 = team2;
		view = v;
		
		tabbedPaneInit();
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		this.add(tabbedPane);
		this.add(backButton,BorderLayout.SOUTH);
		
		this.setModal(true);
		this.setSize(800, 470);
		this.setLocationRelativeTo(view);

	}
	
	private void tabbedPaneInit() {
		tabbedPane = new JTabbedPane();
		
		tabbedPane.add(team1, new GameTeamOutputTab(view,game_id,team1,0));
		tabbedPane.add(team2, new GameTeamOutputTab(view,game_id,team2,0));
		tabbedPane.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		
	}

}
