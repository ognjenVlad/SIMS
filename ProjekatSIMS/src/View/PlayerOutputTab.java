package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerOutputTab extends JPanel implements ActionListener{
	JPanel jp = new JPanel(new GridLayout(1,2));
	JPanel jp2 = new JPanel(new GridLayout(7,2));
	SquaresTable two_points;
	SquaresTable tree_points;
	ArrayList<JLabel> labels;
	
	View v;
	String team;
	int jersey;
	int quarter;
	
	PlayerOutputTab(View v,String team,int jersey,int quarter){
		labels = new ArrayList<JLabel>();
		two_points = new SquaresTable();
		tree_points = new SquaresTable();
		
		jp.add(two_points);
		jp.add(tree_points);
		jp2.add(new JLabel("2 points",SwingConstants.CENTER));
		jp2.add(new JLabel("3 points",SwingConstants.CENTER));
		init();
		
		this.add(jp);
		this.add(jp2,BorderLayout.SOUTH);
		this.repaint();
	}
	
	
	private void init(){
		labels.add(new JLabel("Defensive rebonds:"));
		jp2.add(labels.get(0));
		labels.add(new JLabel("0"));
		jp2.add(labels.get(1));

		labels.add(new JLabel("Offensive rebounds:"));
		jp2.add(labels.get(2));
		labels.add(new JLabel("0"));
		jp2.add(labels.get(3));
		
		labels.add(new JLabel("Travels:"));
		jp2.add(labels.get(4));
		labels.add(new JLabel("0"));
		jp2.add(labels.get(5));
		
		labels.add(new JLabel("Bad passes:"));
		jp2.add(labels.get(6));
		labels.add(new JLabel("0"));
		jp2.add(labels.get(7));
		
		labels.add(new JLabel("Tree seconds:"));
		jp2.add(labels.get(8));
		labels.add(new JLabel("0"));
		jp2.add(labels.get(9));
		
		labels.add(new JLabel("Back courts:"));
		jp2.add(labels.get(10));
		labels.add(new JLabel("0"));
		jp2.add(labels.get(11));
		
		labels.add(new JLabel("Fouls:"));
		jp2.add(labels.get(12));
		labels.add(new JLabel("0"));
		jp2.add(labels.get(13));

		labels.add(new JLabel("Technical fouls:"));
		jp2.add(labels.get(14));
		labels.add(new JLabel("0"));
		jp2.add(labels.get(15));
		
		labels.add(new JLabel("Assists:"));
		jp2.add(labels.get(16));
		labels.add(new JLabel("0"));
		jp2.add(labels.get(17));

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
