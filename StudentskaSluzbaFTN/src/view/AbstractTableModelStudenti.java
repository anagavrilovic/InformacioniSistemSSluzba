package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenti;

public class AbstractTableModelStudenti extends AbstractTableModel {
	
	public AbstractTableModelStudenti() {
		super();
	}

	@Override
	public int getRowCount() {
		return BazaStudenti.getInstance().getStudentList().size();
	}
	
	@Override
	public int getColumnCount() {
		return BazaStudenti.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaStudenti.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenti.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
