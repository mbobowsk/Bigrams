package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class WordModel extends AbstractTableModel {
    
    private final static Object[] columnNames = {"Słowo", "Wystąpienia", "Zdania",
        "Dokumenty", "Procent dokumentów"};
    
    private final ArrayList<WordStats> stats;
    
    public WordModel(ArrayList<WordStats> stats) {
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
        WordStats stat = stats.get(rowIndex);
        switch (columnIndex) {
        case 0: return stat.getWord();
        case 1: return stat.getCount();
        case 2: return stat.getSentenceCount();
        case 3: return stat.getDocCount();
        default: return stat.getDocPercent();
        }
    }
    
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }
 
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
