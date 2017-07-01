package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controler.Controler;
import Model.Team;

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
	private TeamWindow tw;
	private PlayerWindow pw;
	private GameWindow gw;
	private Controler controler;
	public View(){
		super("Basketball statistics");
		
		this.addTeamButton = new JButton("Add team");
		this.addPlayer = new JButton("Add player");
		this.statsTButton = new JButton("Stats for team");
		this.addGame = new JButton("Add game");
		
		JPanel jp = new JPanel(new GridLayout(4, 1));
		
		jp.add(this.addTeamButton); 
		jp.add(this.addPlayer);
		jp.add(this.statsTButton);
		jp.add(this.addGame);
		
		this.addTeamButton.addActionListener(this);
        this.addPlayer.addActionListener(this);
        this.statsTButton.addActionListener(this);
        this.addGame.addActionListener(this);
			
		this.add(jp, BorderLayout.SOUTH);
		this.setSize(800, 600);
		ImageIcon img = new ImageIcon("./resources/fibahands.jpeg");
		
		
		
		this.getContentPane().setBackground(Color.DARK_GRAY);
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
			
			ArrayList<Team> t = controler.readTeamsCont();
			for (Team team : t){
				System.out.println(team.getName());
			}
		
		}else if(src == this.addGame){
			gw = new GameWindow(this);
			gw.setVisible(true);
		}		
	}
	
	public void setControler(Controler c){
		
		this.controler = c;
	}
	public Controler getControler() {
		return controler;
	}
	
}
