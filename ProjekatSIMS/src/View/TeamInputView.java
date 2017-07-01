package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TeamInputView extends JDialog implements ActionListener{
	ArrayList<JButton> playerButtons;
	ArrayList<JLabel> labels;
	ArrayList<PlayerInputView> pInputViews;
	View v;
	JButton saveButton;
	
	JPanel jp;
	
	TeamInputView(View v){
		this.v = v;
		pInputViews = new ArrayList<PlayerInputView>();
		playerButtons = new ArrayList<JButton>();
		labels = new ArrayList<JLabel>();
		saveButton = new JButton("Save");
		jp = new JPanel(new GridLayout(13,2));
		this.setSize(500,500);
		this.setLocationRelativeTo(v);
		this.setModal(true);
	
		init();
	}
	
	private void init() {
		for(int i =0 ; i < 12 ; i++) {
			playerButtons.add(new JButton("+"));
			playerButtons.get(i).addActionListener(this);
			labels.add(new JLabel("Player " + (i+1)));
			pInputViews.add(new PlayerInputView(v));
		}
		
		
		this.add(jp);
		
		for(int i = 0 ; i < 12 ; i++) {
			jp.add(labels.get(i));
			jp.add(playerButtons.get(i));
		}
		
		saveButton.setText("Save");
		
		jp.add(saveButton);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == this.playerButtons.get(0)){
			pInputViews.get(0).setVisible(true);
		}else if(src == this.playerButtons.get(1)){
			pInputViews.get(1).setVisible(true);
		}else if(src == this.playerButtons.get(2)){
			pInputViews.get(2).setVisible(true);
		}else if(src == this.playerButtons.get(3)){
			pInputViews.get(3).setVisible(true);
		}else if(src == this.playerButtons.get(4)) {
			pInputViews.get(4).setVisible(true);
		}else if(src == this.playerButtons.get(5)) {
			pInputViews.get(5).setVisible(true);
		}else if(src == this.playerButtons.get(6)) {
			pInputViews.get(6).setVisible(true);
		}else if(src == this.playerButtons.get(7)) {
			pInputViews.get(7).setVisible(true);
		}else if(src == this.playerButtons.get(8)) {
			pInputViews.get(8).setVisible(true);
		}else if(src == this.playerButtons.get(9)) {
			pInputViews.get(9).setVisible(true);
		}else if(src == this.playerButtons.get(10)) {
			pInputViews.get(10).setVisible(true);
		}else if(src == this.playerButtons.get(11)) {
			pInputViews.get(11).setVisible(true);
		}
		
	}

}
