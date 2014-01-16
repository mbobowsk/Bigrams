package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class TfidfModel extends AbstractTableModel {
	
	private final static Object[] columnNames = {"Słowo", "Dokument", "Wartość tf-idf"};
    
    private final ArrayList<TfidfStats> stats;
    
    public TfidfModel(ArrayList<TfidfStats> stats) {
    	this.stats = stats;
    }

    public int getRowCount() {
        return stats.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }
    
    public Class getColumnClass(int c) {  
    	Object value=this.getValueAt(0,c);  
    	return (value==null?Object.class:value.getClass());  
   }

    public Object getValueAt(int rowIndex, int columnIndex) {
        TfidfStats stat = stats.get(rowIndex);
        switch (columnIndex) {
        case 0: return stat.getWord();
        case 1: return stat.getDoc();
        default: return stat.getValue();
        }
    }
    
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }
 
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
