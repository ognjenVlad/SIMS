package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PlayerInputView extends JDialog implements ActionListener	{

	JButton saveButton = new JButton("Save");
	JTabbedPane tabbedPane = new JTabbedPane();
	View view;
	String game_id;
	String team;
	String jersey;
	
	PlayerInputView(View v,String game_id,String team,String jersey){
		this.view = v;
		this.game_id = game_id;
		this.team = team;
		this.jersey = jersey;
		init();
	}
	
	private void init() {
		this.setModal(true);
		this.setLocationRelativeTo(view);
		this.setTitle("Input for player");
		this.setSize(800, 600);
		
		saveButton.addActionListener(this);
		this.add(tabbedPane);
		tabbedPane.add("Quarter1", new QuarterInputView(view,game_id,team,jersey,1));
		tabbedPane.add("Quarter2", new QuarterInputView(view,game_id,team,jersey,2));
		tabbedPane.add("Quarter3", new QuarterInputView(view,game_id,team,jersey,3));
		tabbedPane.add("Quarter4", new QuarterInputView(view,game_id,team,jersey,4));
		this.add(saveButton,BorderLayout.SOUTH);

	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
