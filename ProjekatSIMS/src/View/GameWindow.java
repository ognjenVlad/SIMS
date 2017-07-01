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
import javax.swing.JPanel;

import Model.Team;

public class GameWindow extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JLabel team1;
	private JLabel team2;
	private JComboBox<String> team1Cb;
	private JComboBox<String> team2Cb;
	private View view;
	private JPanel jp;
	private JButton addGame;
	private JButton cancel;
	private TeamInputView teaminput;
	
	GameWindow(View v){
		super(v,"Add game");
		jp = new JPanel(new GridLayout(3, 1));
		this.view = v;
		
		createComboBox();
		createLabels();
		createPanels();
		createButtons();
		this.add(jp);
		this.setSize(300, 200);
		this.setLocationRelativeTo(v);
	}
	
	
	
	public void createComboBox(){
		this.team1Cb = new JComboBox<String>();
		this.team2Cb = new JComboBox<String>();
		for(Team t: view.getControler().readTeamsCont()){
			System.out.println(t.getName());
			this.team1Cb.addItem(t.getName());
			this.team2Cb.addItem(t.getName());
		}
	}
	public void createLabels(){
		JPanel lab_jp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.team1 = new JLabel("Home: ");
		lab_jp.add(this.team1);
		lab_jp.add(Box.createHorizontalStrut(30));
		this.team2 = new JLabel("Away: ");
		lab_jp.add(this.team2);
		this.jp.add(lab_jp);
	}
	public void createPanels(){
		JPanel cb_jp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cb_jp.add(this.team1Cb);
		cb_jp.add(Box.createHorizontalStrut(30));
		cb_jp.add(this.team2Cb);
		this.jp.add(cb_jp);
	}
	public void createButtons(){
		JPanel but_jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.addGame = new JButton("Add game");
		this.cancel = new JButton("Cancel");
		addGame.addActionListener(this);
		cancel.addActionListener(this);
		but_jp.add(addGame);
		but_jp.add(cancel);
		this.jp.add(but_jp);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent event){
		Object src = event.getSource();
		if(src == this.addGame){
			this.setVisible(false);
			teaminput = new TeamInputView(view);
			teaminput.setVisible(true);
		}else if(src == this.cancel){
			this.dispose();
		}
	}
}
