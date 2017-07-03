package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerOutputTab extends JPanel implements ActionListener{
	JPanel jp = new JPanel(new GridLayout(2,2));
	SquaresTable two_points;
	SquaresTable tree_points;
	ArrayList<JLabel> labels;
	ArrayList<JTextField> textFields;
	
	
	PlayerOutputTab(){
		labels = new ArrayList<JLabel>();
		textFields = new ArrayList<JTextField>();
		two_points = new SquaresTable();
		tree_points = new SquaresTable();
		
		this.add(jp);
		jp.add(two_points);
		jp.add(tree_points);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
