package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuarterInputView extends JPanel implements ActionListener{
	ArrayList<JTextField> textFields;
	ArrayList<JLabel> labels;
	
	
	JPanel jp = new JPanel(new GridLayout(2, 4));
	
	
	QuarterInputView(){
		textFields = new ArrayList<JTextField>();
		labels = new ArrayList<JLabel>();
		
		init();
	}
	
	private void init() {
		labels.add(new JLabel("2 points attempts:"));
		textFields.add(new JTextField());
		
		jp.add(labels.get(0));
		jp.add(textFields.get(0));
		
		labels.add(new JLabel("2 points hit:"));
		textFields.add(new JTextField());
		
		jp.add(labels.get(1));
		jp.add(textFields.get(1));
		
		labels.add(new JLabel("Defensive rebounds:"));
		textFields.add(new JTextField());
		
		jp.add(labels.get(2));
		jp.add(textFields.get(2));
		
		labels.add(new JLabel("Offensive rebounds:"));
		textFields.add(new JTextField());
		
		jp.add(labels.get(3));
		jp.add(textFields.get(3));
		
		this.add(jp);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
