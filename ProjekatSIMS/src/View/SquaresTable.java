package View;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;

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
	this.setFont(new Font("Serif", Font.BOLD, 16));
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
		Double num1 = Double.parseDouble(total.split("-")[0]);
		num1 = Math.round(num1*10d)/10d;
		BigDecimal bd = new BigDecimal(num1.toString());
		bd = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
		Double num2 = Double.parseDouble(total.split("-")[1]);
		num2 = Math.round(num2*10d)/10d;
		BigDecimal bd2 = new BigDecimal(num2.toString());
		bd2 = bd2.setScale(1, BigDecimal.ROUND_HALF_UP);
		
		int intNum;
		if(num1 == 0){
			intNum = 0;
		}{
			Double number = num1/num2;
			number = number * 100;
			intNum = number.intValue();
		}
		model.setValueAt("<html>"+ bd +"-"+ bd2 +"<br/>"+ intNum +"%</html>", row, cell);
	}

}
