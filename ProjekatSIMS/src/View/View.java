package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class  View extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JButton fillButton;
	private final JButton statsPButton;
	private final JButton statsTButton;
	private final CardLayout cl;
	private final JPanel pl_jp;
	public View(){
		super("Basketbal statistics");
		
		this.fillButton = new JButton("Fill data");
		this.statsPButton = new JButton("Stats for player");
		this.statsTButton = new JButton("Stats for team");
		this.cl = new CardLayout();
		JPanel jp = new JPanel(new GridLayout(3, 1));
		jp.add(this.fillButton); 
		jp.add(this.statsPButton);
		jp.add(this.statsTButton);
		
		this.pl_jp = new JPanel(cl);
		this.statsPButton.addActionListener(this);
        this.statsTButton.addActionListener(this);
		
		//this.setLayout(new GridLayout(1, 3));
		
		this.add(jp, BorderLayout.SOUTH);
		this.setSize(800, 600);
		ImageIcon img = new ImageIcon("./resources/fibahands.jpeg");
		
		//this.pack();
		this.add(pl_jp, BorderLayout.NORTH);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setIconImage(img.getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	public void playersPanel(){	
		pl_jp.add(new JLabel("PLAYERS STATS"),"1");

		
	}
	public void teamPanel(){
		
		pl_jp.add(new JLabel("TEAM STATS"),"2");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		Object src = event.getSource();
		playersPanel();
		teamPanel();
		if(src == this.statsPButton){
			cl.show(pl_jp, "1");
			
		}else{
			cl.show(pl_jp, "2");
		}
	}
	
}
