package view;

import javax.swing.table.AbstractTableModel;

public class BigramModel extends AbstractTableModel {
    
    private final static Object[] columnNames = {"Wystąpienia", "Zdania",
        "Dokumenty", "Procent dokumentów", "tf-idf", "P(s1)", "P(s2)", "P(x)"};

    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }
 
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
