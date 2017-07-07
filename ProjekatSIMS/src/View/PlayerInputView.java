package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class PlayerInputView extends JDialog implements ActionListener	{

	JButton saveButton = new JButton("Save");
	JTabbedPane tabbedPane = new JTabbedPane();
	View view;
	String game_id;
	String team;
	String jersey;
	ArrayList<QuarterInputView> quarters = new ArrayList<QuarterInputView>();
	
	PlayerInputView(View v,String game_id,String team,String jersey){
		this.view = v;
		this.game_id = game_id;
		this.team = team;
		this.jersey = jersey;
		init();
	}
	
	private void init() {
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Input for player");
		this.setSize(800, 600);
		saveButton.addActionListener(this);
		this.add(tabbedPane);
		for(int i = 0 ; i < 4 ; i++){
			quarters.add(new QuarterInputView(view,game_id,team,jersey,i+1));
			tabbedPane.add("Quarter "+ (i+1) , quarters.get(i));
		}
		this.add(saveButton,BorderLayout.SOUTH);

	}
	
	public void showPIW(){
		this.setVisible(true);
		for(int i = 0 ; i < 4; i++){
			quarters.get(i).reset();
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < quarters.size(); i++){
			if (!quarters.get(0).checkInputs()) {
				JOptionPane.showMessageDialog(this, "Inputs must be numbers!");
				return;
			}
		}
		for(int i = 0 ; i < quarters.size(); i++) {
			quarters.get(i).saveData();
		}
		this.dispose();
	}

}
