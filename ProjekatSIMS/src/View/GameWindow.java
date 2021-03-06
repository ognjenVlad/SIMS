package View;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameWindow extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel team1;
	private JLabel team2;
	private JComboBox<String> team1Cb;
	private JComboBox<String> team2Cb;
	private View view;
	private JPanel jp;
	private JLabel date;
	private JLabel place;
	private JTextField dateInput;
	private JTextField placeInput;
	private JLabel id;
	private JTextField idInput;
	private JButton addGame;
	private JButton cancel;
	private TeamInputView teaminput;

	GameWindow(View v) {
		super(v, "Add game");
		jp = new JPanel(new GridLayout(6, 1));
		this.view = v;

		createIdInput();
		createComboBox();
		createLabels();
		createPanels();
		createDatePlace();
		createButtons();
		this.add(jp);
		this.setSize(350, 250);
		this.setLocationRelativeTo(v);
	}

	public void createIdInput() {
		JPanel id_jp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.id = new JLabel("Game id: ");
		id_jp.add(this.id);
		this.idInput = new JTextField();
		idInput.setColumns(4);
		id_jp.add(this.idInput);

		this.jp.add(id_jp);
	}

	public void createComboBox() {
		this.team1Cb = new JComboBox<String>();
		this.team2Cb = new JComboBox<String>();
		for (String s : view.getControler().validTeams()) {
			this.team1Cb.addItem(s);
			this.team2Cb.addItem(s);
		}
	}

	public void createLabels() {
		JPanel lab_jp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.team1 = new JLabel("Home: ");
		lab_jp.add(this.team1);
		lab_jp.add(Box.createHorizontalStrut(30));
		this.team2 = new JLabel("Away: ");
		lab_jp.add(this.team2);
		this.jp.add(lab_jp);
	}

	public void createPanels() {
		JPanel cb_jp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cb_jp.add(this.team1Cb);
		cb_jp.add(Box.createHorizontalStrut(30));
		cb_jp.add(this.team2Cb);
		this.jp.add(cb_jp);
	}

	public void createDatePlace() {
		JPanel dateJp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.date = new JLabel("Date(dd.mm.yyyy):");
		this.dateInput = new JTextField();
		this.dateInput.setColumns(7);
		
		dateJp.add(this.date);
		dateJp.add(this.dateInput);
		dateJp.add(Box.createHorizontalStrut(30));

		JPanel placeJp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.place = new JLabel("Place:");
		placeJp.add(Box.createHorizontalStrut(30));
		this.placeInput = new JTextField();
		this.placeInput.setColumns(7);
		placeJp.add(this.place);
		placeJp.add(this.placeInput);
		this.jp.add(dateJp);
		this.jp.add(placeJp);
	}

	public void createButtons() {
		JPanel but_jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.addGame = new JButton("Add game");
		this.cancel = new JButton("Cancel");
		addGame.addActionListener(this);
		cancel.addActionListener(this);
		but_jp.add(addGame);
		but_jp.add(cancel);
		this.jp.add(but_jp);

	}

	public boolean isInt() {

		if (this.idInput.getText().matches("^\\d+$")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean filled() {
		if (this.placeInput.getText().equals("") || this.dateInput.getText().equals("") || !isInt()) {
			return false;
		}

		if (!this.dateInput.getText().matches("([0-9][0-9]).([0-9]{2}).([0-9]{4})")) {
			return false;
		}

		return true;

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object src = event.getSource();
		String team1 = this.team1Cb.getSelectedItem().toString();
		String team2 = this.team2Cb.getSelectedItem().toString();
		String game_id = idInput.getText();
		if (!filled()) {
			JOptionPane.showMessageDialog(this, "Wrong input!");
			return;
		}
		if(view.getControler().ifGameIdExists(this.idInput.getText())){
			JOptionPane.showMessageDialog(this, "Game id already exists!");
			return;
		}
		if(this.team1Cb.getSelectedItem().toString().equals(team2Cb.getSelectedItem().toString())){
			JOptionPane.showMessageDialog(this, "Can't create game between two same teams!");
			return;
		}

		if (src == this.addGame) {
			this.setVisible(false);
			this.view.getControler().processAddGame(game_id, team1, team2, this.dateInput.getText(),
					this.placeInput.getText());
			this.teaminput = new TeamInputView(view, game_id, team1, team2);
			this.teaminput.setVisible(true);
			this.dispose();

		} else if (src == this.cancel) {
			this.dispose();
		}

	}
}
