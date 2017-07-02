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
	
	TeamOutputView(View v){
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
		
		tabbedPane.add("Total", new TeamOutputTab());
		tabbedPane.add("Home", new TeamOutputTab());
		tabbedPane.add("Away", new TeamOutputTab());		
		tabbedPane.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		
	}

}
