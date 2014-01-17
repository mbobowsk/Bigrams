package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;

import model.WordModel;

public class BigramFilterDialog extends JDialog implements ActionListener {
	
	public BigramFilterDialog(JFrame frame, JTable table) {
		super(frame);
        setTitle("Filtr");
        setModal(true);
        BigramFilterPane dlg = new BigramFilterPane(table);
		setContentPane(dlg);
        dlg.getFilterButton().addActionListener(this);
        pack();
	}

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        dispose();
    }

}