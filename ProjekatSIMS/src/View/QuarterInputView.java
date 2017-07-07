package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuarterInputView extends JPanel implements ActionListener {
	ArrayList<JTextField> textFields;
	ArrayList<JLabel> labels;
	
	String game_id;
	String team;
	int jersey;
	int quarter;
	View view;
	
	JPanel jp = new JPanel(new GridLayout(16, 4));

	QuarterInputView(View v,String game_id,String team,String jersey,int quarter) {
		System.out.println(game_id + " - " + team + " - " + jersey + " - " + quarter);
		this.view = v;
		this.game_id = game_id;
		this.jersey = Integer.parseInt(jersey);
		this.team = team;
		this.quarter = quarter;
		
		textFields = new ArrayList<JTextField>();
		labels = new ArrayList<JLabel>();

		init();
		reset();
	}
	
	public void reset(){
		for(int i = 0 ; i < textFields.size(); i++){
			textFields.get(i).setText("0");
		}
		this.repaint();
	}

	private void init() {
		int j = 1;
		for (int i = 0; i < 11; i = i + 2) {
			labels.add(new JLabel("2 points attempts (square " + j + "):"));
			textFields.add(new JTextField());

			jp.add(labels.get(i));
			jp.add(textFields.get(i));
			
			labels.add(new JLabel("2 points hit(square " + j++ + "):"));
			textFields.add(new JTextField());

			jp.add(labels.get(i + 1));
			jp.add(textFields.get(i + 1));
			
		}
		

		
		j=1;
		for(int i = 0 ; i < 8 ; i += 2) {
			
			labels.add(new JLabel("3 points attempts (square  " + j + "):"));
			textFields.add(new JTextField());

			jp.add(labels.get(12+ i));
			jp.add(textFields.get(12 + i));

			labels.add(new JLabel("3 points hit(square " + j++ + "):"));
			textFields.add(new JTextField());

			jp.add(labels.get(13 + i));
			jp.add(textFields.get(13 + i));
			
		}
		
		labels.add(new JLabel("3 points attempts (square  6):"));
		textFields.add(new JTextField());

		jp.add(labels.get(20));
		jp.add(textFields.get(20));

		labels.add(new JLabel("3 points hit(square 6):"));
		textFields.add(new JTextField());

		jp.add(labels.get(21));
		jp.add(textFields.get(21));

		
		labels.add(new JLabel("Defensive rebounds:"));
		textFields.add(new JTextField());

		jp.add(labels.get(22));
		jp.add(textFields.get(22));

		labels.add(new JLabel("Offensive rebounds:"));
		textFields.add(new JTextField());

		jp.add(labels.get(23));
		jp.add(textFields.get(23));

		labels.add(new JLabel("Travels:"));
		textFields.add(new JTextField());

		jp.add(labels.get(24));
		jp.add(textFields.get(24));

		labels.add(new JLabel("Bad passes:"));
		textFields.add(new JTextField());

		jp.add(labels.get(25));
		jp.add(textFields.get(25));

		labels.add(new JLabel("3 seconds:"));
		textFields.add(new JTextField());

		jp.add(labels.get(26));
		jp.add(textFields.get(26));

		labels.add(new JLabel("Back courts:"));
		textFields.add(new JTextField());

		jp.add(labels.get(27));
		jp.add(textFields.get(27));

		labels.add(new JLabel("Fouls:"));
		textFields.add(new JTextField());

		jp.add(labels.get(28));
		jp.add(textFields.get(28));

		labels.add(new JLabel("Technical fouls:"));
		textFields.add(new JTextField());

		jp.add(labels.get(29));
		jp.add(textFields.get(29));

		labels.add(new JLabel("Assists:"));
		textFields.add(new JTextField());

		jp.add(labels.get(30));
		jp.add(textFields.get(30));

		this.add(jp);
		this.setVisible(true);
	}
	public boolean isInt(String param) {

		if (param.matches("^\\d+$")) {
			return true;
		} else {
			return false;
		}
	}
	public boolean checkInputs(){
		for(JTextField jt : textFields){
			if(!isInt(jt.getText())){
				
				return false;
			}
		}
		return true;
	}
	public void saveData() {
		
		int total,miss;
		total = Integer.parseInt(textFields.get(0).getText());
		miss = Integer.parseInt(textFields.get(1).getText());
		
		System.out.println("Hit - Total , 2 pts square 1 :" + miss + "-" + total);
		view.getControler().processAddPoints(game_id, team, jersey, 2, total , miss, 1 , quarter);

		total = Integer.parseInt(textFields.get(2).getText());
		miss = Integer.parseInt(textFields.get(3).getText());
		System.out.println("Hit - Total , 2 pts square 2 :" + miss + "-" + total);
		view.getControler().processAddPoints(game_id, team, jersey, 2, total , miss, 2 , quarter);

		total = Integer.parseInt(textFields.get(4).getText());
		miss = Integer.parseInt(textFields.get(5).getText());
		System.out.println("Hit - Total , 2 pts square 3 :" + miss + "-" + total);
		view.getControler().processAddPoints(game_id, team, jersey, 2, total , miss, 3 , quarter);

		total = Integer.parseInt(textFields.get(6).getText());
		miss = Integer.parseInt(textFields.get(7).getText());
		view.getControler().processAddPoints(game_id, team, jersey, 2, total , miss, 4 , quarter);

		total = Integer.parseInt(textFields.get(8).getText());
		miss = Integer.parseInt(textFields.get(9).getText());
		view.getControler().processAddPoints(game_id, team, jersey, 2, total , miss, 5 , quarter);

		total = Integer.parseInt(textFields.get(10).getText());
		miss = Integer.parseInt(textFields.get(11).getText());
		view.getControler().processAddPoints(game_id, team, jersey, 2, total , miss, 6 , quarter);

		total = Integer.parseInt(textFields.get(12).getText());
		miss = Integer.parseInt(textFields.get(13).getText());
		view.getControler().processAddPoints(game_id, team, jersey, 3, total , miss, 1 , quarter);

		total = Integer.parseInt(textFields.get(14).getText());
		miss = Integer.parseInt(textFields.get(15).getText());
		view.getControler().processAddPoints(game_id, team, jersey, 3, total , miss, 2 , quarter);

		total = Integer.parseInt(textFields.get(16).getText());
		miss = Integer.parseInt(textFields.get(17).getText());
		view.getControler().processAddPoints(game_id, team, jersey, 3, total , miss, 3 , quarter);

		total = Integer.parseInt(textFields.get(18).getText());
		miss = Integer.parseInt(textFields.get(19).getText());
		view.getControler().processAddPoints(game_id, team, jersey, 3, total , miss, 4 , quarter);

		total = Integer.parseInt(textFields.get(20).getText());
		miss = Integer.parseInt(textFields.get(21).getText());
		view.getControler().processAddPoints(game_id, team, jersey, 3, total , miss, 6 , quarter);

		total = Integer.parseInt(textFields.get(22).getText());
		view.getControler().processAddStat(game_id, team, jersey, "def_rebound", total, quarter);

		total = Integer.parseInt(textFields.get(23).getText());
		view.getControler().processAddStat(game_id, team, jersey, "off_rebound", total, quarter);

		total = Integer.parseInt(textFields.get(24).getText());
		view.getControler().processAddStat(game_id, team, jersey, "travel", total, quarter);

		total = Integer.parseInt(textFields.get(25).getText());
		view.getControler().processAddStat(game_id, team, jersey, "bad_pass", total, quarter);

		total = Integer.parseInt(textFields.get(26).getText());
		view.getControler().processAddStat(game_id, team, jersey, "three_sec", total, quarter);

		total = Integer.parseInt(textFields.get(27).getText());
		view.getControler().processAddStat(game_id, team, jersey, "back_court", total, quarter);

		total = Integer.parseInt(textFields.get(28).getText());
		view.getControler().processAddStat(game_id, team, jersey, "foul", total, quarter);

		total = Integer.parseInt(textFields.get(29).getText());
		view.getControler().processAddStat(game_id, team, jersey, "technical", total, quarter);

		total = Integer.parseInt(textFields.get(30).getText());
		view.getControler().processAddStat(game_id, team, jersey, "assist", total, quarter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
