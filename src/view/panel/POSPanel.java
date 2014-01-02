package view.panel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class POSPanel extends JPanel implements ActionListener {
	
	private final JLabel word1 = new JLabel("Słowo 1  ");
	private final JLabel word2 = new JLabel("Słowo 2  ");
	
	private final JButton choose1 = new JButton("Wybierz");
	private final JButton choose2 = new JButton("Wybierz");
	
	private JLabel chosenPos1 = new JLabel("Wszystkie");
	private JLabel chosenPos2 = new JLabel("Wszystkie");
	
	private JPanel word1Pane = new JPanel(new GridBagLayout());
	private JPanel word2Pane = new JPanel(new GridBagLayout());
	
	private JPanel mainPane = new JPanel(new GridLayout(2,1));
	
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
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		word1Pane.add(word1, c);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		word1Pane.add(choose1, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 6;
		c.ipady = 10;
		word1Pane.add(chosenPos1, c);
	}
	
	private void initWord2Pane() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		word2Pane.add(word2, c);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		word2Pane.add(choose2, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 6;
		c.ipady = 10;
		word2Pane.add(chosenPos2, c);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == choose1) {
			
		}
		else {
			
		}
	}
	
}
