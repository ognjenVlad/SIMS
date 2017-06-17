package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class  View extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JButton fillButton;
	private final JButton statsPButton;
	private final JButton statsTButton;
	
	public View(){
		super("Basketbal statistics");
		
		this.fillButton = new JButton("Fill data");
		this.statsPButton = new JButton("Stats for player");
		this.statsTButton = new JButton("Stats for team");
		JPanel jp = new JPanel(new GridLayout(3, 1));
		jp.add(this.fillButton); 
		jp.add(this.statsPButton);
		jp.add(this.statsTButton);
		
		
		//this.setLayout(new GridLayout(1, 3));
		
		this.add(jp, BorderLayout.SOUTH);
		this.setSize(800, 600);
		ImageIcon img = new ImageIcon("./resources/fibahands.jpeg");
		//this.pack();
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setIconImage(img.getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
		
	
}
