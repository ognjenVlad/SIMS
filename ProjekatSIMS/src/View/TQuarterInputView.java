package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TQuarterInputView extends JPanel implements ActionListener{
	ArrayList<JTextField> textFields;
	ArrayList<JLabel> labels;
	
	View view;
	String team;
	int quarter;
	String game_id;
	
	JPanel jp = new JPanel(new GridLayout(5,2));
	
	TQuarterInputView(View view , String game_id , String team , int quarter){
		this.view = view;
		this.game_id = game_id;
		this.team = team;
		this.quarter = quarter;

		textFields = new ArrayList<JTextField>();
		labels = new ArrayList<JLabel>();

		init();
		reset();
		this.add(jp);
		this.setVisible(true);
	}
	
	public void reset(){
		for(int i = 0 ; i < textFields.size(); i++){
			textFields.get(i).setText("0");
		}
		this.repaint();
	}
	
	private void init() {
		labels.add(new JLabel("Timeouts:"));
		textFields.add(new JTextField());

		jp.add(labels.get(0));
		jp.add(textFields.get(0));

		labels.add(new JLabel("24 seconds:"));
		textFields.add(new JTextField());

		jp.add(labels.get(1));
		jp.add(textFields.get(1));

		
		labels.add(new JLabel("8 seconds:"));
		textFields.add(new JTextField());

		jp.add(labels.get(2));
		jp.add(textFields.get(2));

		labels.add(new JLabel("5 seconds:"));
		textFields.add(new JTextField());

		jp.add(labels.get(3));
		jp.add(textFields.get(3));

		labels.add(new JLabel("Trainer techical:"));
		textFields.add(new JTextField());

		jp.add(labels.get(4));
		jp.add(textFields.get(4));

	}
	
	public void saveData() {
		int total;
		
		total = Integer.parseInt(textFields.get(0).getText());
		view.getControler().processAddTStat(game_id,team,"timeout",total,quarter);

		total = Integer.parseInt(textFields.get(1).getText());
		view.getControler().processAddTStat(game_id,team,"twotree_seconds",total,quarter);
		
		total = Integer.parseInt(textFields.get(2).getText());
		view.getControler().processAddTStat(game_id,team,"eight_seconds",total,quarter);

		total = Integer.parseInt(textFields.get(3).getText());
		view.getControler().processAddTStat(game_id,team,"five_seconds",total,quarter);

		total = Integer.parseInt(textFields.get(4).getText());
		view.getControler().processAddTStat(game_id,team,"trainer_technical",total,quarter);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


}
