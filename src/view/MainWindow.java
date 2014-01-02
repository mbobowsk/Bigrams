package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import view.panel.BigramType;
import view.panel.POSPanel;
import view.panel.PathPanel;

public class MainWindow extends JFrame {
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JPanel optionPanel = new JPanel(new GridBagLayout());
	private JPanel wordPanel = new JPanel();
	private JPanel stemPanel = new JPanel();
	private JPanel bigramPanel = new JPanel();
	
	private JPanel buttonPane = new JPanel();
	private JButton run = new JButton("Start");
	
	public MainWindow() {
		super("Statystyki bigramów");
		optionPanel.setPreferredSize(new Dimension(450,270));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		optionPanel.add(new PathPanel());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		optionPanel.add(new PathPanel(), c);
		
		c.gridx = 0;
		c.gridy = 1;
		optionPanel.add(new BigramType(), c);
		
		c.gridx = 0;
		c.gridy = 2;
		optionPanel.add(new POSPanel(), c);
		
		buttonPane.add(run);
		c.gridx = 0;
		c.gridy = 3;
		optionPanel.add(buttonPane, c);
		
		tabbedPane.add("Opcje", optionPanel);
		tabbedPane.add("Słowa", wordPanel);
		tabbedPane.add("Słowa (forma podstawowa)", stemPanel);
		tabbedPane.add("Bigramy", bigramPanel);
		getContentPane().add(tabbedPane);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainWindow();

	}

}
