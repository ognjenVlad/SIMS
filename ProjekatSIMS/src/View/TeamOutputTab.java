package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TeamOutputTab extends JPanel implements ActionListener{
	
	JTable teamTable;
	JTable fieldsTable;
	
	
	TeamOutputTab(){
		init();
	}
	
	
	private void init() {
		teamTableInit();
		fieldsTableInit();
		
		this.add(teamTable);
		this.add(fieldsTable);
		this.setVisible(true);
	}
	
	private void teamTableInit() {
		teamTable = new JTable(12,10) {
			 public boolean isCellEditable(int data, int columns)
             {
                 return false;
             }
		};
		
		
		
		DefaultTableModel model = (DefaultTableModel) teamTable.getModel();
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
	
	private void fieldsTableInit() {
		fieldsTable = new JTable(2,3) {
			 public boolean isCellEditable(int data, int columns)
             {
                 return false;
             }
		};
		
		fieldsTable.setRowHeight(0,80);
		fieldsTable.setRowHeight(1,80);
		fieldsTable.setFont(new Font("Serif", Font.BOLD, 20));
		fieldsTable.setBackground(Color.LIGHT_GRAY);

		
		TableColumnModel tcm = fieldsTable.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(80);
		tcm.getColumn(1).setPreferredWidth(80);
		tcm.getColumn(2).setPreferredWidth(80);

		DefaultTableModel model = (DefaultTableModel) fieldsTable.getModel();
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER );
		centerRenderer.setVerticalAlignment(DefaultTableCellRenderer.CENTER);
		tcm.getColumn(0).setCellRenderer(centerRenderer);
		tcm.getColumn(1).setCellRenderer(centerRenderer);
		tcm.getColumn(2).setCellRenderer(centerRenderer);

//		model.setValueAt("<html> <center> 10/20 <br/> 50% </center> </html>", 1, 1);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
