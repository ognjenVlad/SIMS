package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerOutputTab extends JPanel implements ActionListener{
	JPanel finalJP = new JPanel(new GridLayout(2, 1));
	JPanel jp = new JPanel(new FlowLayout());
	JPanel jp2 = new JPanel(new GridLayout(14,2));
	SquaresTable two_points;
	SquaresTable three_points;
	ArrayList<JLabel> labels;
	
	View view;
	String team;
	int jersey;
	int quarter;
	
	PlayerOutputTab(View v,String team,int jersey,int quarter){
		this.view = v;
		this.team = team;
		this.jersey = jersey;
		this.quarter = quarter;
		
		labels = new ArrayList<JLabel>();
		two_points = new SquaresTable(){
			 public boolean isCellEditable(int data, int columns)
             {
                 return false;
             }
		};
		three_points = new SquaresTable(){
			 public boolean isCellEditable(int data, int columns)
             {
                 return false;
             }
		};
		
		jp.add(two_points);
		jp.add(Box.createHorizontalStrut(5));
		jp.add(three_points);
		jp2.add(new JLabel("2 points",SwingConstants.CENTER));
		jp2.add(new JLabel("3 points",SwingConstants.CENTER));
		jp2.add(Box.createVerticalStrut(10));
		jp2.add(Box.createVerticalStrut(10));
		init();
		
		finalJP.add(jp,BorderLayout.NORTH);
		
		finalJP.add(jp2,BorderLayout.SOUTH);
		this.add(finalJP);
		
		fillData();
		this.repaint();
	}
	
	
	private void init(){
		
		labels.add(new JLabel("Free throws:"));
		jp2.add(labels.get(0));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(1));

		labels.add(new JLabel("Defensive rebonds:"));
		jp2.add(labels.get(2));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(3));

		labels.add(new JLabel("Offensive rebounds:"));
		jp2.add(labels.get(4));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(5));
		
		labels.add(new JLabel("Travels:"));
		jp2.add(labels.get(6));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(7));
		
		labels.add(new JLabel("Bad passes:"));
		jp2.add(labels.get(8));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(9));
		
		labels.add(new JLabel("3 seconds:"));
		jp2.add(labels.get(10));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(11));
		
		labels.add(new JLabel("Back courts:"));
		jp2.add(labels.get(12));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(13));
		
		labels.add(new JLabel("Fouls:"));
		jp2.add(labels.get(14));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(15));

		labels.add(new JLabel("Technical fouls:"));
		jp2.add(labels.get(16));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(17));
		
		labels.add(new JLabel("Assists:"));
		jp2.add(labels.get(18));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(19));

		labels.add(new JLabel("Blocks:"));
		jp2.add(labels.get(20));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(21));

		labels.add(new JLabel("Steals:"));
		jp2.add(labels.get(22));
		labels.add(new JLabel("0",SwingConstants.CENTER));
		jp2.add(labels.get(23));
}
	
	private void fillData(){
		
		double[] totalFGs = new double[6];
		double[] hitFGs = new double[6];
		double[] total3Pts = new double[6];
		double[] hit3Pts = new double[6];
		
		for(int i=0 ; i < 6 ; i++) {
			totalFGs[i] = 0;
			hitFGs[i] = 0;
		}
		
		for(int i=0 ; i < 5 ; i++) {
			total3Pts[i] = 0;
			hit3Pts[i] = 0;
		}
		
		
		
		double ft_total;
		double ft_miss;

		totalFGs[0] = view.getControler().countAvgShots(team, jersey, 2, false, 1, quarter);
		hitFGs[0] = view.getControler().countAvgShots(team, jersey, 2, true, 1, quarter);
		totalFGs[0] += hitFGs[0];
		
		totalFGs[1] = view.getControler().countAvgShots(team, jersey, 2, false, 2, quarter);
		hitFGs[1] = view.getControler().countAvgShots(team, jersey, 2, true, 2, quarter);
		totalFGs[1] += hitFGs[1];


		totalFGs[2] = view.getControler().countAvgShots(team, jersey, 2, false, 3, quarter);
		hitFGs[2] = view.getControler().countAvgShots(team, jersey, 2, true, 3, quarter);
		totalFGs[2] += hitFGs[2];

		totalFGs[3] = view.getControler().countAvgShots(team, jersey, 2, false, 4, quarter);
		hitFGs[3] = view.getControler().countAvgShots(team, jersey, 2, true, 4, quarter);
		totalFGs[3] += hitFGs[3];

		totalFGs[4] = view.getControler().countAvgShots(team, jersey, 2, false, 5, quarter);
		hitFGs[4] = view.getControler().countAvgShots(team, jersey, 2, true, 5, quarter);
		totalFGs[4] += hitFGs[4];

		totalFGs[5] = view.getControler().countAvgShots(team, jersey, 2, false, 6, quarter);
		hitFGs[5] = view.getControler().countAvgShots(team, jersey, 2, true, 6, quarter);
		totalFGs[5] += hitFGs[5];

		total3Pts[0] =  view.getControler().countAvgShots(team, jersey, 3, false, 1, quarter);
		hit3Pts[0] = view.getControler().countAvgShots(team, jersey, 3, false, 1, quarter);
		total3Pts[0] += hit3Pts[0];

		total3Pts[1] =  view.getControler().countAvgShots(team, jersey, 3, false, 2, quarter);
		hit3Pts[1] = view.getControler().countAvgShots(team, jersey, 3, false, 2, quarter);
		total3Pts[1] += hit3Pts[1];

		total3Pts[2] =  view.getControler().countAvgShots(team, jersey, 3, false, 3, quarter);
		hit3Pts[2] = view.getControler().countAvgShots(team, jersey, 3, false, 3, quarter);
		total3Pts[2] += hit3Pts[2];

		total3Pts[3] =  view.getControler().countAvgShots(team, jersey, 3, false, 4, quarter);
		hit3Pts[3] = view.getControler().countAvgShots(team, jersey, 3, false, 4, quarter);
		total3Pts[3] += hit3Pts[3];

		total3Pts[4] =  view.getControler().countAvgShots(team, jersey, 3, false, 5, quarter);
		hit3Pts[4] = view.getControler().countAvgShots(team, jersey, 3, false, 5, quarter);
		total3Pts[4] += hit3Pts[4];

		
		two_points.changeCell(1, 0, Double.toString(hitFGs[0])+"-"+Double.toString(totalFGs[0]));
		two_points.changeCell(1, 1, Double.toString(hitFGs[1])+"-"+Double.toString(totalFGs[1]));
		two_points.changeCell(1, 2, Double.toString(hitFGs[2])+"-"+Double.toString(totalFGs[2]));
		two_points.changeCell(0, 0, Double.toString(hitFGs[3])+"-"+Double.toString(totalFGs[3]));
		two_points.changeCell(0, 1, Double.toString(hitFGs[4])+"-"+Double.toString(totalFGs[4]));
		two_points.changeCell(0, 2, Double.toString(hitFGs[5])+"-"+Double.toString(totalFGs[5]));

		three_points.changeCell(1, 0, Double.toString(hit3Pts[0])+"-"+Double.toString(total3Pts[0]));
		three_points.changeCell(1, 1, Double.toString(hit3Pts[1])+"-"+Double.toString(total3Pts[1]));
		three_points.changeCell(1, 2, Double.toString(hit3Pts[2])+"-"+Double.toString(total3Pts[2]));
		three_points.changeCell(0, 0, Double.toString(hit3Pts[3])+"-"+Double.toString(total3Pts[3]));
		three_points.changeCell(0, 2, Double.toString(hit3Pts[4])+"-"+Double.toString(total3Pts[4]));
		
		
		ft_total = view.getControler().countAvgShots(team, jersey , 1 , true, 1, quarter);
		ft_miss = view.getControler().countAvgShots(team, jersey , 1 , false, 1, quarter);
		
		ft_total += ft_miss;
		
		labels.get(1).setText(ft_miss+"-"+ft_total);
		labels.get(3).setText(view.getControler().countAvgStat(team, jersey , "def_rebounds", quarter)+"");
		labels.get(5).setText(view.getControler().countAvgStat(team, jersey , "off_rebounds", quarter)+"");
		labels.get(7).setText(view.getControler().countAvgStat(team, jersey, "travel", quarter)+"");
		labels.get(9).setText(view.getControler().countAvgStat(team, jersey, "bad_pass", quarter)+"");
		labels.get(11).setText(view.getControler().countAvgStat(team, jersey, "three_sec", quarter)+"");
		labels.get(13).setText(view.getControler().countAvgStat(team, jersey, "foul", quarter)+"");
		labels.get(15).setText(view.getControler().countAvgStat(team, jersey, "technical_foul", quarter)+"");
		labels.get(17).setText(view.getControler().countAvgStat(team, jersey, "back_court", quarter)+"");
		labels.get(19).setText(view.getControler().countAvgStat(team, jersey, "assist", quarter)+"");
		labels.get(21).setText(view.getControler().countAvgStat(team, jersey, "block", quarter)+"");
		labels.get(23).setText(view.getControler().countAvgStat(team, jersey, "steal", quarter)+"");

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
