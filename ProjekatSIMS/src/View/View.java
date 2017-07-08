package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controler.Controler;

/**
 * 
 * Klasa koja predstavlja mainwindow(JFrame)
 * @author Ogauzz
 *
 */
public final class  View extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private final JButton addTeamButton;
	private final JButton addPlayer;
	private final JButton statsTButton;
	private final JButton addGame;
	private final JButton statsPlayerButton;
	private final JButton statsGameButton;
	private TeamWindow tw;
	private PlayerWindow pw;
	private GameWindow gw;
	private Controler controler;
	private TeamDialog teamDialog;
	private PlayerDialog playerDialog;
	private GameDialog gameDialog;
	
	public View(){
		super("Basketball statistics");
		
		
		
		this.statsPlayerButton = new JButton("Stats for player");
		this.statsTButton = new JButton("Stats for team");
		this.statsGameButton = new JButton("Stats for game");
		this.addGame = new JButton("Add game");
		this.addTeamButton = new JButton("Add team");
		this.addPlayer = new JButton("Add player");
		
		JPanel jp = new JPanel(new GridLayout(6, 1));
		
		jp.add(this.statsPlayerButton);
		jp.add(this.statsGameButton);
		jp.add(this.statsTButton);
		jp.add(this.addTeamButton); 
		jp.add(this.addPlayer);
		jp.add(this.addGame);
		
		
		this.addTeamButton.addActionListener(this);
        this.addPlayer.addActionListener(this);
        this.statsTButton.addActionListener(this);
        this.addGame.addActionListener(this);
        this.statsPlayerButton.addActionListener(this);
        this.statsGameButton.addActionListener(this);
        
		this.add(jp, BorderLayout.EAST);
		
		ImageIcon img = new ImageIcon("./resources/fibahands.jpeg");
		
		
		JLabel picture = new JLabel(new ImageIcon("./resources/fiba-logo.jpeg"));
		this.add(picture);
		this.pack();
		this.setIconImage(img.getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event){
		Object src = event.getSource();
		if(src == this.addTeamButton){
			tw = new TeamWindow(this);
			tw.setVisible(true);
		}else if(src == this.addPlayer){
			
			pw = new PlayerWindow(this);
			pw.setVisible(true);
		
		}else if(src == this.statsTButton){
				
			this.teamDialog = new TeamDialog(this);
			this.teamDialog.setVisible(true);
			
		}else if(src == this.addGame){
			gw = new GameWindow(this);
			gw.setVisible(true);
			
		}else if(src == this.statsPlayerButton){
			this.playerDialog = new PlayerDialog(this);
			this.playerDialog.setVisible(true);
		}else if(src == this.statsGameButton){
			this.gameDialog = new GameDialog(this);
			this.gameDialog.setVisible(true);
		}		
	}
	
	public void setControler(Controler c){
		
		this.controler = c;
	}
	public Controler getControler() {
		return controler;
	}
	
}
