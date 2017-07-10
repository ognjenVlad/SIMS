package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

public class PlayerOutputView extends JDialog implements ActionListener{
	View view;
	String team;
	int jersey;
	
	JTabbedPane tabbedPane;
	
	PlayerOutputView(View v,String team,int jersey){
		super(v, "Player view");
		view = v;
		
		this.team = team;
		this.jersey = jersey;
		
		tabbedPane = new JTabbedPane();
		tabbedPane.add("Total", new PlayerOutputTab(v,team,jersey,0));
		tabbedPane.add("Quarter1", new PlayerOutputTab(v,team,jersey,1));
		tabbedPane.add("Quarter2", new PlayerOutputTab(v,team,jersey,2));
		tabbedPane.add("Quarter3", new PlayerOutputTab(v,team,jersey,3));
		tabbedPane.add("Quarter4", new PlayerOutputTab(v,team,jersey,4));

		this.add(tabbedPane);
		this.pack();
		this.setLocationRelativeTo(view);
		tabbedPane.setVisible(true);
		this.setModal(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
