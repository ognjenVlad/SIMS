package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;

public class TeamOutputView extends JDialog implements ActionListener{
	
	JTabbedPane tabbedPane;
	JButton backButton;
	
	View view;
	String team;
	
	TeamOutputView(View v,String team){
		view = v;
		this.team = team;
		
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
		
		tabbedPane.add("Total", new TeamOutputTab(view,team,0));
		tabbedPane.add("Quarter1", new TeamOutputTab(view,team,1));
		tabbedPane.add("Quarter2", new TeamOutputTab(view,team,2));		
		tabbedPane.add("Quarter3", new TeamOutputTab(view,team,3));		
		tabbedPane.add("Quarter4", new TeamOutputTab(view,team,4));		
		tabbedPane.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		
	}

}
