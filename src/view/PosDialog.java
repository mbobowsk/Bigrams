/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JDialog;
import javax.swing.JFrame;


/**
 *
 * @author preston
 */
public class PosDialog extends JDialog {
    
	public PosDialog(JFrame frame) {
		super(frame);
		setContentPane(new DialogPane());
	}
}
