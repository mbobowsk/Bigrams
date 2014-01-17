package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import sql.SQLRead;
import logic.GateController;
import logic.Options;
import model.ModelLogic;
import model.WordModel;

public class AppWindow extends javax.swing.JFrame implements ActionListener {

	/**
	 * Creates new form AppWindow
	 */
	public AppWindow() {
		initComponents();
		initMenu();
		initTables();
	}
	
	private void initMenu() {
	    JMenuItem menuItem = new JMenuItem("Filtruj");
	    menuItem.addActionListener(this);
	    popup.add(menuItem);
	    
	    MouseListener popupListener = new PopupListener(popup);
	    wordTable.addMouseListener(popupListener);
	    basicWordTable.addMouseListener(popupListener);
	}
	
	private void initTables() {
		initTable(wordTable, wordPane);
		initTable(basicWordTable, basicWordPane);
	}
	
	private void initTable(JTable table, JScrollPane pane) {
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);
		pane.setViewportView(table);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// If one model is null then others are null too
		if (wordModel == null)
			return;
		
		int index = tabbedPane.getSelectedIndex();

		switch (index) {
		case 1:
			WordFilterDialog wdf = new WordFilterDialog(this, wordTable);
			wdf.setVisible(true);
			break;
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        choosePos1 = new javax.swing.JButton();
        choosePath = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        chosenPath = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        followingWords = new javax.swing.JRadioButton();
        wholeSentence = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        run = new javax.swing.JButton();
        choosePos2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        outFileName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        loadResults = new javax.swing.JButton();
        wordPane = new javax.swing.JScrollPane();
        basicWordPane = new javax.swing.JScrollPane();
        bigramPane = new javax.swing.JScrollPane();
        basicBigramPane = new javax.swing.JScrollPane();
        wordTfidfPane = new javax.swing.JScrollPane();
        basicWordTfidfPane = new javax.swing.JScrollPane();
        bigramTfidfPane = new javax.swing.JScrollPane();
        basicBigramTfidfPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Rodzaj bigramów");

        choosePos1.setText("Wybierz");
        choosePos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePos1ActionPerformed(evt);
            }
        });

        choosePath.setText("Wybierz");
        choosePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePathActionPerformed(evt);
            }
        });

        jLabel5.setText("Słowo 1");

        chosenPath.setText("...");

        jLabel6.setText("Słowo 2");

        jLabel4.setText("Części mowy");

        buttonGroup.add(followingWords);
        followingWords.setSelected(true);
        followingWords.setText("Kolejne słowa");

        buttonGroup.add(wholeSentence);
        wholeSentence.setText("Wszystkie słowa w zdaniu");

        jLabel1.setText("Plik/katalog wejściowy");

        run.setText("Uruchom");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        choosePos2.setText("Wybierz");
        choosePos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePos2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel2.setText("Przeprowadź symulację");

        jLabel7.setText("Nazwa pliku wyjściowego");

        outFileName.setText("out.sqlite");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(run)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(chosenPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(choosePath))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(followingWords)
                                            .addComponent(wholeSentence)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(choosePos2))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(choosePos1)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(outFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))))
                        .addGap(0, 75, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(choosePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chosenPath)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(followingWords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wholeSentence)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(choosePos1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(choosePos2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(run)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel8.setText("Wczytaj wyniki");

        loadResults.setText("Wczytaj");
        loadResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadResultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(loadResults)
                        .addGap(74, 74, 74))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(loadResults))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab("Opcje", jPanel1);
        tabbedPane.addTab("Słowa", wordPane);
        tabbedPane.addTab("Słowa (lemma)", basicWordPane);
        tabbedPane.addTab("Bigramy", bigramPane);
        tabbedPane.addTab("Bigramy (lemma)", basicBigramPane);
        tabbedPane.addTab("Słowa tf-idf", wordTfidfPane);
        tabbedPane.addTab("Słowa (lemma) tf-idf", basicWordTfidfPane);
        tabbedPane.addTab("Bigramy tf-idf", bigramTfidfPane);
        tabbedPane.addTab("Bigramy (lemma) tf-idf", basicBigramTfidfPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void choosePos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePos1ActionPerformed
		PosDialog dlg = new PosDialog(this, activeModel1, inactiveModel1);
		dlg.setVisible(true);
	}//GEN-LAST:event_choosePos1ActionPerformed

	private void choosePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePathActionPerformed
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int ret = fc.showOpenDialog(this);
		if (ret == JFileChooser.APPROVE_OPTION) {
			String name = fc.getCurrentDirectory() + File.separator + fc.getName(fc.getSelectedFile());
			chosenPath.setText(name);
		}
	}//GEN-LAST:event_choosePathActionPerformed

	private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
		Options options = getOptions();
		try {
			GateController gc = new GateController();
			gc.calculate(options);
			fillTables(options.getFileName());
		} catch (Exception e) {
			e.printStackTrace();
		}        

	}//GEN-LAST:event_runActionPerformed

	private void choosePos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePos2ActionPerformed
		PosDialog dlg = new PosDialog(this, activeModel2, inactiveModel2);
		dlg.setVisible(true);
	}//GEN-LAST:event_choosePos2ActionPerformed

    private void loadResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadResultsActionPerformed
        JFileChooser fc = new JFileChooser();
	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	int ret = fc.showOpenDialog(this);
	if (ret == JFileChooser.APPROVE_OPTION) {
            fillTables(fc.getSelectedFile().getPath());
	}
    }//GEN-LAST:event_loadResultsActionPerformed

	// gets data from SQLite file and shows it to the user
	private void fillTables(String path) {
		try {
			SQLRead read = new SQLRead(path);

			wordModel = read.getWordModel(false);
			wordTable.setModel(wordModel);
			
			basicWordModel = read.getWordModel(false);
			basicWordTable.setModel(basicWordModel);
			
			addTable(read.getTfidfModel(false), wordTfidfPane);
			addTable(read.getTfidfModel(true), basicWordTfidfPane);
			addTable(read.getBigramModel(false), bigramPane);
			addTable(read.getBigramModel(true), basicBigramPane);
			addTable(read.getBigramTfidfModel(false), bigramTfidfPane);
			addTable(read.getBigramTfidfModel(true), basicBigramTfidfPane);
			read.closeConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addTable(AbstractTableModel model, JScrollPane pane) {
		JTable table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);
		pane.setViewportView(table);
	}
	private Options getOptions() {
		Options.BigramType type = getBigramType();
		ArrayList<String> paths = getPaths();
		ArrayList<String> posPane1 = ModelLogic.getShortNamesFromModel(activeModel1);
		ArrayList<String> posPane2 = ModelLogic.getShortNamesFromModel(activeModel2);
		return new Options(paths, type, posPane1, posPane2, outFileName.getText());
	}

	private Options.BigramType getBigramType() {
		if (followingWords.isSelected())
			return Options.BigramType.FOLLOWING_WORDS;
		else
			return Options.BigramType.SENTENCE;
	}

	private ArrayList<String> getPaths() {
		ArrayList<String> ret = new ArrayList<String>();
		String path = chosenPath.getText();
		File file = new File(path);

		if (file.isDirectory()) {
			for (File fileEntry : file.listFiles())
				ret.add(path + File.separator + fileEntry.getName());
		}
		else {
			ret.add(path);
		}
		return ret;
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AppWindow().setVisible(true);
			}
		});
	}

	private DefaultListModel activeModel1 = ModelLogic.initPosModel();
	private DefaultListModel inactiveModel1 = new DefaultListModel();
	private DefaultListModel activeModel2 = ModelLogic.initPosModel();
	private DefaultListModel inactiveModel2 = new DefaultListModel();
	
	private JTable wordTable = new JTable();
	private JTable basicWordTable = new JTable();
	
	private WordModel wordModel = null;
	private WordModel basicWordModel = null;
	
	private JPopupMenu popup = new JPopupMenu();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane basicBigramPane;
    private javax.swing.JScrollPane basicBigramTfidfPane;
    private javax.swing.JScrollPane basicWordPane;
    private javax.swing.JScrollPane basicWordTfidfPane;
    private javax.swing.JScrollPane bigramPane;
    private javax.swing.JScrollPane bigramTfidfPane;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton choosePath;
    private javax.swing.JButton choosePos1;
    private javax.swing.JButton choosePos2;
    private javax.swing.JLabel chosenPath;
    private javax.swing.JRadioButton followingWords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loadResults;
    private javax.swing.JTextField outFileName;
    private javax.swing.JButton run;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JRadioButton wholeSentence;
    private javax.swing.JScrollPane wordPane;
    private javax.swing.JScrollPane wordTfidfPane;
    // End of variables declaration//GEN-END:variables
}
