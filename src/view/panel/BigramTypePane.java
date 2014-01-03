package view.panel;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BigramTypePane extends JPanel {
	
	private final JRadioButton followingWords = new JRadioButton("Kolejne słowa");
	private final JRadioButton wholeSentence = new JRadioButton("Wszystkie słowa w zdaniu");
	private final JPanel buttonsPane = new JPanel();
	private final ButtonGroup bg = new ButtonGroup();
	
	public BigramTypePane() {
		super();
		buttonsPane.setBorder(BorderFactory.createTitledBorder("Rodzaj bigramów"));
		buttonsPane.add(followingWords);
		buttonsPane.add(wholeSentence);
		add(buttonsPane);
		
		bg.add(followingWords);
		bg.add(wholeSentence);
		
		followingWords.setSelected(true);
	}

	public JRadioButton getFollowingWords() {
		return followingWords;
	}
}
