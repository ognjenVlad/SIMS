package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuarterInputView extends JPanel implements ActionListener {
	ArrayList<JTextField> textFields;
	ArrayList<JLabel> labels;

	JPanel jp = new JPanel(new GridLayout(16, 4));

	QuarterInputView() {
		textFields = new ArrayList<JTextField>();
		labels = new ArrayList<JLabel>();

		init();
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

		labels.add(new JLabel("Tree seconds:"));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// addShots(String game_id,int shot_for,int total, int good , int pos , int
		// quart)
		// addShots("",2,textFields.get(0), textFields.get(1) , 1 , 1);
		// addShots("",2,textFields.get(2), textFields.get(3) , 2 , 1);
		// addShots("",2,textFields.get(4), textFields.get(5) , 3 , 1);
		// addShots("",2,textFields.get(6), textFields.get(7) , 4 , 1);
		// addShots("",2,textFields.get(8), textFields.get(9) , 5 , 1);
		// addShots("",2,textFields.get(10), textFields.get(11) , 6 , 1);

		// addShots("",3,textFields.get(12), textFields.get(13) , 1 , 1);
		// addShots("",3,textFields.get(14), textFields.get(15) , 3 , 1);
		// addShots("",3,textFields.get(16), textFields.get(17) , 4 , 1);
		// addShots("",3,textFields.get(18), textFields.get(19) , 5 , 1);
		// addShots("",3,textFields.get(20), textFields.get(21) , 6 , 1);

		// addStats(String game_id,String add_what,int amount,int quart);
		// addStats("","def_rebound",textFields.get(22), 1);
		// addStats("","off_rebound",textFields.get(23), 1);
		// addStats("","travel",textFields.get(24), 1);
		// addStats("","bad_pass",textFields.get(25), 1);
		// addStats("","tree_sec",textFields.get(26), 1);
		// addStats("","back_court",textFields.get(27), 1);
		// addStats("","foul",textFields.get(28), 1);
		// addStats("","technical_foul",textFields.get(29), 1);
		// addStats("","assist",textFields.get(30), 1);

	}

}
