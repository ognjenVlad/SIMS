package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TeamOutputTab extends JPanel implements ActionListener{
	
	JTable teamTable;
	SquaresTable fieldsTable;
	JPanel jp;
	ArrayList<JLabel> labels;
	View view;
	String team;
	int quarter;
	DefaultTableModel model;
	
	TeamOutputTab(View v ,String team,int quarter){
		this.view = v;
		this.team = team;
		this.quarter = quarter;
		init();
	}
	
	
	private void init() {
		jp = new JPanel(new GridLayout(5,2));
		fieldsTable = new SquaresTable(){
			 public boolean isCellEditable(int data, int columns)
             {
                 return false;
             }
		};
		
		labels = new ArrayList<JLabel>();
		teamTableInit();
		
		initJP();
		
		fillWithData();
		this.add(teamTable);
		this.add(fieldsTable);
		this.add(jp);
		this.setVisible(true);
	}
	
	private void teamTableInit() {
		teamTable = new JTable(13,10) {
			 public boolean isCellEditable(int data, int columns)
             {
                 return false;
             }
		};
		
		model = (DefaultTableModel) teamTable.getModel();
		
		model.setValueAt("Field Goal", 0, 1);
		model.setValueAt("3 point", 0, 2);
		model.setValueAt("Free Throw", 0, 3);
		model.setValueAt("O. Reb", 0, 4);
		model.setValueAt("D. Reb", 0, 5);
		model.setValueAt("Assists", 0, 6);
		model.setValueAt("Turnovers", 0, 7);
		model.setValueAt("+/-", 0, 8);
		model.setValueAt("Points", 0, 9);
		
		TableColumnModel tcm = teamTable.getColumnModel();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER );
		centerRenderer.setVerticalAlignment(DefaultTableCellRenderer.CENTER);
		for(int i = 0 ; i < 10 ; i++) {
			tcm.getColumn(i).setCellRenderer(centerRenderer);
		}
		

	}
	
	
	private void initJP() {
		labels.add(new JLabel("Timeouts:"));
		labels.add(new JLabel());

		jp.add(labels.get(0));
		jp.add(labels.get(1));

		labels.add(new JLabel("24 seconds:"));
		labels.add(new JLabel());

		jp.add(labels.get(2));
		jp.add(labels.get(3));

		
		labels.add(new JLabel("8 seconds:"));
		labels.add(new JLabel());

		jp.add(labels.get(4));
		jp.add(labels.get(5));

		labels.add(new JLabel("5 seconds:"));
		labels.add(new JLabel());

		jp.add(labels.get(6));
		jp.add(labels.get(7));

		labels.add(new JLabel("Trainer techical:"));
		labels.add(new JLabel());

		jp.add(labels.get(8));
		jp.add(labels.get(9));

	}
	
	
	private void fillWithData() {
		double twoPoints_square1;
		double twoPoints_hit_square1;
		double twoPoints_square2;
		double twoPoints_hit_square2;
		double twoPoints_square3;
		double twoPoints_hit_square3;
		double twoPoints_square4;
		double twoPoints_hit_square4;
		double twoPoints_square5;
		double twoPoints_hit_square5;
		double twoPoints_square6;
		double twoPoints_hit_square6;
		
		double treePoints_square1;
		double treePoints_hit_square1;
		double treePoints_square2;
		double treePoints_hit_square2;
		double treePoints_square3;
		double treePoints_hit_square3;
		double treePoints_square4;
		double treePoints_hit_square4;
		double treePoints_square5;
		double treePoints_hit_square5;
		double treePoints_square6;
		double treePoints_hit_square6;
		
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
		
		double currentFG;
		double current3Pts;
		double currentFGhits;
		double current3Ptshits;
		
		double currretPlayerFG;
		double currentPlayerFGhit;
		double currretPlayer3Pts;
		double currentPlayer3Ptshit;
		
		
		double d_rebounds;
		double o_rebounds;
		double assists;
		double turnovers;
		double index;
		double points;
		
		ArrayList<String> players = view.getControler().getPlayersSorter(team);
		for(int i = 0 ; i < players.size(); i++) {
			currentFG = totalFGs[0] + totalFGs[1] + totalFGs[2] + totalFGs[3] + totalFGs[4] + totalFGs[5];
			currentFGhits = hitFGs[0] + hitFGs[1] + hitFGs[2] + hitFGs[3] + hitFGs[4] + hitFGs[5];

			current3Pts = total3Pts[0] + total3Pts[1] + total3Pts[2] + total3Pts[3] + total3Pts[4];
			current3Ptshits = hit3Pts[0] + hit3Pts[1] + hit3Pts[2] + hit3Pts[3] + hit3Pts[4];

			twoPoints_square1 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 1, quarter);
			twoPoints_hit_square1 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 1, quarter);
			totalFGs[0] += twoPoints_square1 + twoPoints_hit_square1;
			hitFGs[0] += twoPoints_hit_square1;
			twoPoints_square2 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 2, quarter);
			twoPoints_hit_square2 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 2, quarter);
			totalFGs[1] += twoPoints_square2 + twoPoints_hit_square2;
			hitFGs[1] += twoPoints_hit_square2;
			twoPoints_square3 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 3, quarter);
			twoPoints_hit_square3 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 3, quarter);
			totalFGs[2] += twoPoints_square3 + twoPoints_hit_square3;
			hitFGs[2] += twoPoints_hit_square3;
			twoPoints_square4 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 4, quarter);
			twoPoints_hit_square4 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 4, quarter);
			totalFGs[3] += twoPoints_square4 + twoPoints_hit_square4;
			hitFGs[3] += twoPoints_hit_square4;
			twoPoints_square5 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 5, quarter);
			twoPoints_hit_square5 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 5, quarter);
			totalFGs[4] += twoPoints_square5 + twoPoints_hit_square5;
			hitFGs[4] += twoPoints_hit_square5;
			twoPoints_square6 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 6, quarter);
			twoPoints_hit_square6 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 6, quarter);
			totalFGs[4] += twoPoints_square6 + twoPoints_hit_square6;
			hitFGs[4] += twoPoints_hit_square6;
			
			treePoints_square1 =  view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 1, quarter);
			treePoints_hit_square1 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 1, quarter);
			total3Pts[0] += treePoints_square1 + treePoints_hit_square1;
			hit3Pts[0] += treePoints_hit_square1;
			treePoints_square2 =  view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 2, quarter);
			treePoints_hit_square2 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 2, quarter);
			total3Pts[1] += treePoints_square2 + treePoints_hit_square2;
			hit3Pts[1] += treePoints_hit_square2;
			treePoints_square3 =  view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 3, quarter);
			treePoints_hit_square3 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 3, quarter);
			total3Pts[2] += treePoints_square3 + treePoints_hit_square3;
			hit3Pts[2] += treePoints_hit_square3;
			treePoints_square4 =  view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 4, quarter);
			treePoints_hit_square4 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 4, quarter);
			total3Pts[3] += treePoints_square3 + treePoints_hit_square3;
			hit3Pts[3] += treePoints_hit_square4;
			treePoints_square5 =  view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 5, quarter);
			treePoints_hit_square5 = view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 5, quarter);
			total3Pts[4] += treePoints_square4 + treePoints_hit_square4;
			hit3Pts[4] += treePoints_hit_square4;

			
			currretPlayerFG = totalFGs[0] + totalFGs[1] + totalFGs[2] + totalFGs[3] + totalFGs[4] + totalFGs[5] - currentFG;
			currentPlayerFGhit = hitFGs[0] + hitFGs[1] + hitFGs[2] + hitFGs[3] + hitFGs[4] + hitFGs[5] - currentFGhits;
			
			currretPlayer3Pts = total3Pts[0] + total3Pts[1] + total3Pts[2] + total3Pts[3] + total3Pts[4] - current3Pts;
			currentPlayer3Ptshit = hit3Pts[0] + hit3Pts[1] + hit3Pts[2] + hit3Pts[3] + hit3Pts[4] - current3Ptshits;
			
			model.setValueAt(players.get(i), i+1, 0);
			
			model.setValueAt(currentPlayerFGhit + "-" + currretPlayerFG, i+1, 1); // 2 pt
			model.setValueAt(currretPlayer3Pts + "-" + currentPlayer3Ptshit, i+1, 2); // 3 pt
						
			model.setValueAt("0", i+1, 3); // ft

			o_rebounds = view.getControler().countAvgStat(team, Integer.parseInt(players.get(i).split(",")[0]), "off_rebounds", quarter);

			model.setValueAt(o_rebounds+"", i+1, 4); // O.Reb
			
			d_rebounds = view.getControler().countAvgStat(team, Integer.parseInt(players.get(i).split(",")[0]), "def_rebounds", quarter);

			model.setValueAt(o_rebounds + "", i+1, 5); // D.Reb

			assists = view.getControler().countAvgStat(team, Integer.parseInt(players.get(i).split(",")[0]), "assist", quarter);

			model.setValueAt(assists + "", i+1, 6); // Asists

			turnovers = 0;
			turnovers += view.getControler().countAvgStat(team, Integer.parseInt(players.get(i).split(",")[0]), "back_court", quarter);
			turnovers += view.getControler().countAvgStat(team, Integer.parseInt(players.get(i).split(",")[0]), "tree_sec", quarter);
			turnovers += view.getControler().countAvgStat(team, Integer.parseInt(players.get(i).split(",")[0]), "travel", quarter);
			turnovers += view.getControler().countAvgStat(team, Integer.parseInt(players.get(i).split(",")[0]), "bad_pass", quarter);

			model.setValueAt(turnovers + "", i+1, 7); // Turnovers
			
			index = 0;
			
			model.setValueAt(index + "", i+1, 8); // Index
			
			points = currentPlayerFGhit * 2 + currretPlayer3Pts * 3;
			
			model.setValueAt(points + "", i+1, 9);// Points
			
			
		}
		
		totalFGs[0] += total3Pts[0];
		totalFGs[1] += total3Pts[1];
		totalFGs[2] += total3Pts[2];
		totalFGs[3] += total3Pts[3];
		totalFGs[5] += total3Pts[4];
		
		hitFGs[0] += hit3Pts[0];
		hitFGs[1] += hit3Pts[1];
		hitFGs[2] += hit3Pts[2];
		hitFGs[3] += hit3Pts[3];
		hitFGs[5] += hit3Pts[4];
		
		fieldsTable.changeCell(1, 0, Double.toString(hitFGs[0])+"-"+Double.toString(totalFGs[0]));
		fieldsTable.changeCell(1, 1, Double.toString(hitFGs[1])+"-"+Double.toString(totalFGs[1]));
		fieldsTable.changeCell(1, 2, Double.toString(hitFGs[2])+"-"+Double.toString(totalFGs[2]));
		fieldsTable.changeCell(0, 0, Double.toString(hitFGs[3])+"-"+Double.toString(totalFGs[3]));
		fieldsTable.changeCell(0, 1, Double.toString(hitFGs[4])+"-"+Double.toString(totalFGs[4]));
		fieldsTable.changeCell(0, 2, Double.toString(hitFGs[5])+"-"+Double.toString(totalFGs[5]));
		
		labels.get(5).setText(view.getControler().countAvgTStat(team, "eight_seconds", quarter)+"");
		labels.get(7).setText(view.getControler().countAvgTStat(team, "five_seconds", quarter)+"");
		labels.get(1).setText(view.getControler().countAvgTStat(team, "timeout", quarter)+"");
		labels.get(9).setText(view.getControler().countAvgTStat(team, "trainer_technical", quarter)+"");
		labels.get(3).setText(view.getControler().countAvgTStat(team, "twotree_seconds", quarter)+"");
		
		this.repaint();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
