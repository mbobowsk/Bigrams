package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import logic.types.TfidfBigramStats;

public class TfidfBigramModel extends AbstractTableModel {
	
	private final static Object[] columnNames = {"Słowo1", "Słowo2", "Dokument", "Wartość tf-idf"};
    
    private final ArrayList<TfidfBigramStats> stats;
    
    public TfidfBigramModel(ArrayList<TfidfBigramStats> stats) {
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
    	TfidfBigramStats stat = stats.get(rowIndex);
        switch (columnIndex) {
        case 0: return stat.getWord1();
        case 1: return stat.getWord2();
        case 2: return stat.getDoc();
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
