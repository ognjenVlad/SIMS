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
	String team1;
	String team2;
	
	GameOutputView(View v,String team1,String team2){
		super(v, "Game view");
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
		
		tabbedPane.add("Team1", new TeamOutputTab(view,team1,0));
		tabbedPane.add("Team2", new TeamOutputTab(view,team2,0));
		tabbedPane.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		
	}

}
