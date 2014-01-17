package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;

import model.WordModel;

public class WordFilterDialog extends JDialog implements ActionListener {
	
	public WordFilterDialog(JFrame frame, JTable table) {
		super(frame);
        setTitle("Filtr");
        setModal(true);
        WordFilterPane dlg = new WordFilterPane(table);
		setContentPane(dlg);
        dlg.getFilterButton().addActionListener(this);
        pack();
	}

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        dispose();
    }

}
