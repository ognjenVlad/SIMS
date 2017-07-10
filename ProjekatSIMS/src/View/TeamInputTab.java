package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TeamInputTab extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	ArrayList<JButton> playerButtons;
	ArrayList<JLabel> labels;
	ArrayList<PlayerInputView> pInputViews;
	View view;
	JButton teamStatsButton;
	
	
	String game_id;
	String team;
	
	JPanel jp;
	TStatInputView tstatView;
	
	
	TeamInputTab(View v,String game_id,String team){
		this.game_id = game_id;
		this.team = team;
		
		this.view = v;

		pInputViews = new ArrayList<PlayerInputView>();
		tstatView = new TStatInputView(view,game_id,team);
		playerButtons = new ArrayList<JButton>();
		labels = new ArrayList<JLabel>();
		
		jp = new JPanel();

		teamStatsButton = new JButton("Add team stats");
		teamStatsButton.addActionListener(this);
		
		
	
		init();
		

	}
	
	private void init() {
		ArrayList<String> players = view.getControler().getPlayersSorter(team);
		JPanel jpPlayers = new JPanel(new GridLayout(14,2));
		for(int i =0 ; i < 12 ; i++) {
			playerButtons.add(new JButton("+"));
			playerButtons.get(i).addActionListener(this);
			pInputViews.add(new PlayerInputView(view,game_id,team,players.get(i).split(",")[0]));
		}
		
		for(int i = 0 ; i < players.size(); i++){
			labels.add(new JLabel(players.get(i)));
		}
		for(int i = players.size(); i < 12 ;i++){
			labels.add(new JLabel("Player"));			
		}
		
		
		
		for(int i = 0 ; i < 12 ; i++) {
			jpPlayers.add(labels.get(i));
			jpPlayers.add(playerButtons.get(i));
		}
		jpPlayers.add(Box.createHorizontalStrut(2));
		jpPlayers.add(Box.createHorizontalStrut(2));
		jpPlayers.add(this.teamStatsButton);
		this.jp.add(jpPlayers);
		
		this.add(jp);
		
		
		this.setVisible(true);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == this.playerButtons.get(0)){
			pInputViews.get(0).showPIW();
		}else if(src == this.playerButtons.get(1)){
			pInputViews.get(1).showPIW();
		}else if(src == this.playerButtons.get(2)){
			pInputViews.get(2).showPIW();
		}else if(src == this.playerButtons.get(3)){
			pInputViews.get(3).showPIW();
		}else if(src == this.playerButtons.get(4)) {
			pInputViews.get(4).showPIW();
		}else if(src == this.playerButtons.get(5)) {
			pInputViews.get(5).showPIW();
		}else if(src == this.playerButtons.get(6)) {
			pInputViews.get(6).showPIW();
		}else if(src == this.playerButtons.get(7)) {
			pInputViews.get(7).showPIW();
		}else if(src == this.playerButtons.get(8)) {
			pInputViews.get(8).showPIW();
		}else if(src == this.playerButtons.get(9)) {
			pInputViews.get(9).showPIW();
		}else if(src == this.playerButtons.get(10)) {
			pInputViews.get(10).showPIW();
		}else if(src == this.playerButtons.get(11)) {
			pInputViews.get(11).showPIW();
		}else if(src == this.teamStatsButton) {
			tstatView.showTSW();
		}
		
	}

}
