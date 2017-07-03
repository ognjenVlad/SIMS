package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SquaresTable extends JTable{
	DefaultTableModel model = (DefaultTableModel) this.getModel();

	SquaresTable(){
	super(2, 3);
	
	this.setFocusable(false);
	this.setRowSelectionAllowed(false);
	
	this.setRowHeight(0,80);
	this.setRowHeight(1,80);
	this.setFont(new Font("Serif", Font.BOLD, 20));
	this.setBackground(Color.LIGHT_GRAY);

	
	TableColumnModel tcm = this.getColumnModel();
	tcm.getColumn(0).setPreferredWidth(80);
	tcm.getColumn(1).setPreferredWidth(80);
	tcm.getColumn(2).setPreferredWidth(80);

	
	
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER );
	centerRenderer.setVerticalAlignment(DefaultTableCellRenderer.CENTER);
	tcm.getColumn(0).setCellRenderer(centerRenderer);
	tcm.getColumn(1).setCellRenderer(centerRenderer);
	tcm.getColumn(2).setCellRenderer(centerRenderer);
	}
	
	public void changeCell(int row , int cell,String total){
		// total = "number-number"
		Double number = Double.parseDouble(total.split("-")[1]) / Double.parseDouble(total.split("-")[0]);
		number = number * 100;
		int num2 = number.intValue();
		model.setValueAt("<html>"+ total +"<br/>"+ num2 +"%</html>", row, cell);
	}

}
