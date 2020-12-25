package model;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredmeti extends AbstractTableModel{


	public AbstractTableModelPredmeti() {}

	public int getRowCount() {
		return BazaPredmeti.getInstance().getPredmeti().size();
	}
	
	public int getColumnCount() {
		return BazaPredmeti.getInstance().getColumnCount();
	}

	public String getColumnName(int column) {
		return BazaPredmeti.getInstance().getColumnName(column);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeti.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
