package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class BigramModel extends AbstractTableModel {
    
    private final static Object[] columnNames = {
    	"Słowo 1", "Słowo 2",
    	"Wystąpienia", "Zdania",
        "Dokumenty", "Procent dokumentów", "P(s1)", "P(s2)", "P(x)"};

    private final ArrayList<BigramStats> stats;
    public BigramModel(ArrayList<BigramStats> bigramsStats) {
		stats = bigramsStats;
	}

	public int getRowCount() {
		return stats.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        BigramStats stat = stats.get(rowIndex);
        switch (columnIndex) {
        case 0: return stat.getWord1();
        case 1: return stat.getWord2();
        case 2: return stat.getCount();
        case 3: return stat.getSentenceCount();
        case 4: return stat.getDocCount();
        case 5: return stat.getDocPercent();
        case 6: return stat.getPs1();
        case 7: return stat.getPs2();
        default: return stat.getPx();
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
    
    public Class getColumnClass(int c) {  
    	Object value=this.getValueAt(0,c);  
    	return (value==null?Object.class:value.getClass());  
   }
}
