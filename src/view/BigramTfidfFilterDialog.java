package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;

public class BigramTfidfFilterDialog extends JDialog implements ActionListener {
	
	public BigramTfidfFilterDialog(JFrame frame, JTable table) {
		super(frame);
        setTitle("Filtr");
        setModal(true);
        BigramTfidfPane dlg = new BigramTfidfPane(table);
		setContentPane(dlg);
        dlg.getFilterButton().addActionListener(this);
        pack();
	}

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        dispose();
    }

}