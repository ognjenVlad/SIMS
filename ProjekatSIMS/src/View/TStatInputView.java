package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class TStatInputView extends JDialog implements ActionListener {
	JTabbedPane tabbedPane;
	ArrayList<TQuarterInputView> quarters;
	JButton addButton;
	View view;
	String game_id;
	String team;

	TStatInputView(View view, String game_id, String team) {
		this.view = view;
		this.team = team;
		this.game_id = game_id;

		this.setLocationRelativeTo(view);
		this.setSize(350, 220);
		quarters = new ArrayList<TQuarterInputView>();
		tabbedPane = new JTabbedPane();
		addButton = new JButton("Add");
		this.addButton.addActionListener(this);
		init();

		this.add(tabbedPane);
		this.add(addButton, BorderLayout.SOUTH);
		this.setModal(true);

	}

	public void showTSW() {
		this.setVisible(true);
		for (int i = 0; i < 4; i++) {
			quarters.get(i).reset();
		}
	}

	private void init() {
		quarters.add(new TQuarterInputView(view, game_id, team, 1));
		tabbedPane.add("Quarter1", quarters.get(0));
		quarters.add(new TQuarterInputView(view, game_id, team, 2));
		tabbedPane.add("Quarter2", quarters.get(1));
		quarters.add(new TQuarterInputView(view, game_id, team, 3));
		tabbedPane.add("Quarter3", quarters.get(2));
		quarters.add(new TQuarterInputView(view, game_id, team, 4));
		tabbedPane.add("Quarter4", quarters.get(3));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < quarters.size(); i++){
			if (!quarters.get(0).checkInputs()) {
				JOptionPane.showMessageDialog(this, "Inputs must be numbers!");
				return;
			}
		}
		for (int i = 0; i < quarters.size(); i++) {
			
			quarters.get(0).saveData();

			this.dispose();
		}

	}

}
