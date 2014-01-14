package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import logic.types.WordStats;

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

    @Override
    public int getColumnCount() {
        return columnNames.length;
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
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }
 
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
