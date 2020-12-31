package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeti;

public class AbstractTableModelProfesorPredajePredmete  extends AbstractTableModel{
	
	public AbstractTableModelProfesorPredajePredmete() {}

	public int getRowCount() {
		
		if(!(BazaPredmeti.getInstance().getPredmeti() == null))
			return BazaPredmeti.getInstance().getProfesorPredaje().size();
		else
			return -1;
	}
	
	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int column) {
		return BazaPredmeti.getInstance().getColumNameProf(column);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeti.getInstance().getValueAtProfesorPredmeti(rowIndex, columnIndex);
	}
}
