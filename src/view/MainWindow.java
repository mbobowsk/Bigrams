package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import view.panel.PathPanel;

public class MainWindow extends JFrame {
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JPanel optionPanel = new JPanel();
	private JPanel wordPanel = new JPanel();
	private JPanel stemPanel = new JPanel();
	private JPanel bigramPanel = new JPanel();
	
	public MainWindow() {
		super("Statystyki bigramów");
		optionPanel.setPreferredSize(new Dimension(800,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		optionPanel.add(new PathPanel());
		tabbedPane.add("Opcje", optionPanel);
		tabbedPane.add("Słowa", wordPanel);
		tabbedPane.add("Słowa (forma podstawowa)", stemPanel);
		tabbedPane.add("Bigramy", bigramPanel);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainWindow();

	}

}
