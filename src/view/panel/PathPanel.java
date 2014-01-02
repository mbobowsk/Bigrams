package view.panel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PathPanel extends JPanel implements ActionListener {
	
	private final JLabel chooseFileLabel = new JLabel("Plik/katalog wejściowy:  ");
	private final JButton chooseButton = new JButton("Wybierz");
	private JLabel chosenPath = new JLabel("...");
	private final JFileChooser fc = new JFileChooser();

	public PathPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(chooseFileLabel, c);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		add(chooseButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 6;
		add(chosenPath, c);
		
		chooseButton.addActionListener(this);
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		int ret = fc.showOpenDialog(this);
		if (ret == JFileChooser.APPROVE_OPTION) {
			String name = fc.getCurrentDirectory() + "/" + fc.getName(fc.getSelectedFile());
			chosenPath.setText("");
			chosenPath.setText(name);
		}
	}

}
