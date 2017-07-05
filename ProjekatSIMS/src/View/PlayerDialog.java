package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private View view;
	private JComboBox<String> playersCb;
	private JComboBox<String> teamsCb;
	private JPanel jp;
	private JButton showPlayer;
	private PlayerOutputView playerView;
	
	public PlayerDialog(View v){
		super(v, "Player stats");
		this.view = v;
		init();
		showPlayer.addActionListener(this);
		this.pack();
		this.setLocationRelativeTo(v);
	}
	public void init(){
		this.jp = new JPanel(new GridLayout(6, 2));
		teamComboBox();
		createComboBox();
		showPlayer = new JButton("Show player");
		jp.add(Box.createHorizontalStrut(30));
		jp.add(Box.createHorizontalStrut(30));
		
		jp.add(new JLabel("Team: "));
		jp.add(this.teamsCb);
		
		jp.add(Box.createHorizontalStrut(30));
		jp.add(Box.createHorizontalStrut(30));
		
		jp.add(new JLabel("Player: "));
		jp.add(this.playersCb);
		
		jp.add(Box.createHorizontalStrut(30));
		jp.add(Box.createHorizontalStrut(30));
		jp.add(showPlayer);
		
		this.add(jp);
		
	}
	void teamComboBox(){
		this.teamsCb = new JComboBox<String>();
		for(String s: this.view.getControler().getTeamNames()){
			this.teamsCb.addItem(s);
		}
		this.teamsCb.addActionListener(this);
	}
	public void createComboBox(){
		this.playersCb = new JComboBox<String>();
		for (String s : this.view.getControler().getPlayers(this.teamsCb.getSelectedItem().toString())) {
			playersCb.addItem(s);
		}
	}
	public void changePlayerCb(){
		this.playersCb.removeAllItems();
		for (String s : this.view.getControler().getPlayers(this.teamsCb.getSelectedItem().toString())) {
			playersCb.addItem(s);
		}
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		Object src = event.getSource();
		if(src == this.showPlayer){
			String player = this.playersCb.getSelectedItem().toString();
			String jersyNum = player.split(" ")[0];
			playerView = new PlayerOutputView(this.view,this.teamsCb.getSelectedItem().toString(),Integer.valueOf(jersyNum));
			playerView.setVisible(true);
			this.dispose();
		}else if(src == this.teamsCb){
			changePlayerCb();
		}
	}

}
