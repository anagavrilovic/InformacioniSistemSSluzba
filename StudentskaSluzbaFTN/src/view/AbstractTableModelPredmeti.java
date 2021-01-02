package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeti;

public class AbstractTableModelPredmeti extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableModelPredmeti() {}

	public int getRowCount() {
		if(!(BazaPredmeti.getInstance().getPredmeti() == null))
			return BazaPredmeti.getInstance().getPredmeti().size();
		else
			return -1;
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
