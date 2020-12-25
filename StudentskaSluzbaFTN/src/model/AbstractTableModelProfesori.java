package model;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelProfesori extends AbstractTableModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableModelProfesori() {}

	public int getRowCount() {
		return BazaProfesori.getInstance().getProfesori().size();
	}
	
	public int getColumnCount() {
		return BazaProfesori.getInstance().getColumnCount();
	}

	public String getColumnName(int column) {
		return BazaProfesori.getInstance().getColumnName(column);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesori.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
