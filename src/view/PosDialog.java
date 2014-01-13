package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class PosDialog extends JDialog implements ActionListener {
    
	public PosDialog(JFrame frame, DefaultListModel active, DefaultListModel inactive) {
		super(frame);
                setTitle("Wybór części mowy");
                DialogPane dlg = new DialogPane(active, inactive);
		setContentPane(dlg);
                dlg.getOkButton().addActionListener(this);
                pack();
	}

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        dispose();
    }
}
