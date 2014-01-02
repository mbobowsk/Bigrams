package view.panel;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BigramType extends JPanel {
	
	JRadioButton followingWords = new JRadioButton("Kolejne słowa");
	JRadioButton wholeSentence = new JRadioButton("Wszystkie słowa w zdaniu");
	JPanel buttonsPane = new JPanel();
	ButtonGroup bg = new ButtonGroup();
	
	public BigramType() {
		super();
		buttonsPane.setBorder(BorderFactory.createTitledBorder("Rodzaj bigramów"));
		buttonsPane.add(followingWords);
		buttonsPane.add(wholeSentence);
		add(buttonsPane);
		
		bg.add(followingWords);
		bg.add(wholeSentence);
		
		followingWords.setSelected(true);
	}
}
