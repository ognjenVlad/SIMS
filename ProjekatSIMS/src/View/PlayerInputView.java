package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PlayerInputView extends JDialog implements ActionListener	{

	JButton saveButton = new JButton("Save");
	JTabbedPane tabbedPane = new JTabbedPane();
	View v;
	
	PlayerInputView(View v){
		this.v = v;
		init();
	}
	
	private void init() {
		this.setModal(true);
		this.setLocationRelativeTo(v);
		this.setTitle("Input for player");
		this.setSize(800, 600);
		
		saveButton.addActionListener(this);
		this.add(tabbedPane);
		tabbedPane.add("Quarter1", new QuarterInputView());
		tabbedPane.add("Quarter2", new QuarterInputView());
		tabbedPane.add("Quarter3", new QuarterInputView());
		tabbedPane.add("Quarter4", new QuarterInputView());
		this.add(saveButton,BorderLayout.SOUTH);

	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
