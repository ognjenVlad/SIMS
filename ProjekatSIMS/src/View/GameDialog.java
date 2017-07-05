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

public class GameDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private View view;
	private GameOutputView gameView;
	private JButton showGame;
	private JComboBox<String> gamesCb;
	private JPanel jp;
	public GameDialog(View v) {
		super(v, "Game stats");
		this.view = v;
		init();
		showGame.addActionListener(this);
		
		this.pack();
		this.setLocationRelativeTo(v);
	}
	public void init(){
		this.jp = new JPanel(new GridLayout(5, 2));
		createComboBox();
		showGame = new JButton("Show game");
		jp.add(Box.createHorizontalStrut(30));
		jp.add(Box.createHorizontalStrut(30));
		
		jp.add(new JLabel("Game: "));
		jp.add(this.gamesCb);
		
		jp.add(Box.createHorizontalStrut(30));
		jp.add(Box.createHorizontalStrut(30));
		jp.add(showGame);
		
		this.add(jp);
		
	}
	public void createComboBox(){
		this.gamesCb = new JComboBox<String>();
		for(String s: this.view.getControler().getGames()){
			this.gamesCb.addItem(s);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String game = this.gamesCb.getSelectedItem().toString();
		gameView = new GameOutputView(view,game.split(" ")[2],game.split(" ")[4]);
		gameView.setVisible(true);
		this.dispose();

	}

}
