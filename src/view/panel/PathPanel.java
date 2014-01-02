package view.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PathPanel extends JPanel {
	
	private JLabel inputFile = new JLabel("Plik/katalog wejściowy");
	private JButton choose = new JButton("Wybierz");
	private JLabel chosenPath = new JLabel("/c/home/dupa.txt");
	BorderLayout layout = new BorderLayout();
	

	public PathPanel() {
		super();
		setLayout(layout);
		add(inputFile, BorderLayout.CENTER);
		add(choose, BorderLayout.CENTER);
		add(chosenPath, BorderLayout.LINE_END);
	}

}
