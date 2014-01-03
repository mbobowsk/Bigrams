package view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import logic.Options;
import logic.Options.BigramType;

import view.panel.BigramTypePane;
import view.panel.POSPanel;
import view.panel.PathPanel;

public class MainWindow extends JFrame implements ActionListener {
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JPanel optionPanel = new JPanel(new GridBagLayout());
	private JPanel wordPanel = new JPanel();
	private JPanel stemPanel = new JPanel();
	private JPanel bigramPanel = new JPanel();
	
	private BigramTypePane bigramTypePane = new BigramTypePane();
	private PathPanel pathPane = new PathPanel();
	private POSPanel posPane = new POSPanel();
	
	private JPanel buttonPane = new JPanel();
	private JButton run = new JButton("Start");
	
	public MainWindow() {
		super("Statystyki bigramów");
		optionPanel.setPreferredSize(new Dimension(450,280));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
		optionPanel.add(pathPane);
		optionPanel.add(bigramTypePane);
		optionPanel.add(posPane);
		buttonPane.add(run);
		optionPanel.add(buttonPane);
		
		tabbedPane.add("Opcje", optionPanel);
		tabbedPane.add("Słowa", wordPanel);
		tabbedPane.add("Słowa (forma podstawowa)", stemPanel);
		tabbedPane.add("Bigramy", bigramPanel);
		setContentPane(tabbedPane);
		pack();
		setVisible(true);
		
		run.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		getOptions();
		
	}
	
	private Options getOptions() {
		BigramType type = getBigramType();
		ArrayList<String> paths = getPaths();
		return new Options(paths, type, posPane.getPos1(), posPane.getPos2());
	}
	
	private BigramType getBigramType() {
		if (bigramTypePane.getFollowingWords().isSelected())
			return BigramType.FOLLOWING_WORDS;
		else
			return BigramType.SENTENCE;
	}
	
	private ArrayList<String> getPaths() {
		ArrayList<String> ret = new ArrayList<String>();
		String chosenPath = pathPane.getChosenPath().getText();
		File file = new File(chosenPath);
		
		if (file.isDirectory()) {
			for (File fileEntry : file.listFiles())
				ret.add(fileEntry.getName());
		}
		else {
			ret.add(chosenPath);
		}
		return ret;
	}

}
