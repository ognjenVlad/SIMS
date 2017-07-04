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
		teamTableInit();
		fieldsTableInit();
		fieldsTable = new SquaresTable();
		labels = new ArrayList<JLabel>();
		
		initJP();
		
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
		
		fillWithData();

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
	
	private void fieldsTableInit() {

//		model.setValueAt("<html> <center> 10/20 <br/> 50% </center> </html>", 1, 1);
	
	}
	
	private void fillWithData() {
		String twoPoints_square1;
		String twoPoints_hit_square1;
		String twoPoints_square2;
		String twoPoints_hit_square2;
		String twoPoints_square3;
		String twoPoints_hit_square3;
		String twoPoints_square4;
		String twoPoints_hit_square4;
		String twoPoints_square5;
		String twoPoints_hit_square5;
		String twoPoints_square6;
		String twoPoints_hit_square6;
		
		String treePoints_square1;
		String treePoints_hit_square1;
		String treePoints_square2;
		String treePoints_hit_square2;
		String treePoints_square3;
		String treePoints_hit_square3;
		String treePoints_square4;
		String treePoints_hit_square4;
		String treePoints_square5;
		String treePoints_hit_square5;
		String treePoints_square6;
		String treePoints_hit_square6;

		
		
		ArrayList<String> players = view.getControler().getPlayersSorter(team);
		for(int i = 0 ; i < players.size(); i++) {
			twoPoints_square1 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 1, 0));
			twoPoints_hit_square1 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 1, 0));
			twoPoints_square2 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 2, 0));
			twoPoints_hit_square2 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 2, 0));
			twoPoints_square3 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 3, 0));
			twoPoints_hit_square3 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 3, 0));
			twoPoints_square4 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 4, 0));
			twoPoints_hit_square4 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 4, 0));
			twoPoints_square5 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 5, 0));
			twoPoints_hit_square5 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 5, 0));
			twoPoints_square6 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, false, 6, 0));
			twoPoints_hit_square6 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 2, true, 6, 0));
			
			treePoints_square1 =  Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 1, 0));
			treePoints_hit_square1 = Double.toString(view.getControler().countAvgShots(team, Integer.parseInt(players.get(i).split(",")[0]), 3, false, 1, 0));
			
			model.setValueAt(players.get(i), i+1, 0);
			
			model.setValueAt("0", i+1, 1); // 2 pt
			model.setValueAt("0", i+1, 2); // 3 pt
			model.setValueAt("0", i+1, 3); // ft
			model.setValueAt("0", i+1, 4); // O.Reb
			model.setValueAt("0", i+1, 5); // D.Reb
			model.setValueAt("0", i+1, 6); // Asists
			model.setValueAt("0", i+1, 7); // Turnovers
			model.setValueAt("0", i+1, 8); // Index
			model.setValueAt("0", i+1, 9);// Points
			

		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
