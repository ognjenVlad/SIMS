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
	View v;
	JTabbedPane tabbedPane;
	JButton saveButton;
	
	
	TeamInputView(View v){
		this.v = v;
		
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
		
		this.tabbedPane.add(new TeamInputTab(v),"Home");
		this.tabbedPane.add(new TeamInputTab(v),"Away");

		this.tabbedPane.setVisible(true);
}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
