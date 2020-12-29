package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeti;
import model.BazaStudenti;

public class AbstractTableModelPolozeniIspiti extends AbstractTableModel {
	
	private String index;
	
	public AbstractTableModelPolozeniIspiti(String index) {
		this.index = index;
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeti.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		if(!(BazaStudenti.getInstance().pronadjiStudenta(index).getSpisakPolozenih() == null))
			return BazaStudenti.getInstance().pronadjiStudenta(index).getSpisakPolozenih().size();
		else
			return -1;
	}
	
	public String getColumnName(int column) {
		return BazaPredmeti.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenti.getInstance().pronadjiStudenta(index).getValueAt(rowIndex, columnIndex);
	}

}
