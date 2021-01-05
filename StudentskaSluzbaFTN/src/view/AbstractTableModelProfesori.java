package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesori;

public class AbstractTableModelProfesori extends AbstractTableModel{
	
	public AbstractTableModelProfesori() {}

	public int getRowCount() {
		return BazaProfesori.getInstance().prikaziProfesore().size();
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
