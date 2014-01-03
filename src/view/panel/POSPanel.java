package view.panel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class POSPanel extends JPanel implements ActionListener {
	
	private final JLabel word1 = new JLabel("Słowo 1  ");
	private final JLabel word2 = new JLabel("Słowo 2  ");
	
	private final JButton choose1 = new JButton("Wybierz");
	private final JButton choose2 = new JButton("Wybierz");
	
	private JPanel word1Pane = new JPanel(new GridBagLayout());
	private JPanel word2Pane = new JPanel(new GridBagLayout());
	
	private JPanel mainPane = new JPanel(new GridLayout(2,1));
	
	private ArrayList<String> pos1 = null;
	private ArrayList<String> pos2 = null;
	
	public POSPanel() {
		super();
		
		initWord1Pane();
		initWord2Pane();
		
		mainPane.setBorder(BorderFactory.createTitledBorder("Części mowy"));
		mainPane.add(word1Pane);
		mainPane.add(word2Pane);
		add(mainPane);
		
		choose1.addActionListener(this);
		choose2.addActionListener(this);
	}
	
	private void initWord1Pane() {
		word1Pane.add(word1);
		word1Pane.add(choose1);
	}
	
	private void initWord2Pane() {
		word2Pane.add(word2);
		word2Pane.add(choose2);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == choose1) {
			
		}
		else {
			
		}
	}

	public ArrayList<String> getPos1() {
		return pos1;
	}

	public ArrayList<String> getPos2() {
		return pos2;
	}
	
}
