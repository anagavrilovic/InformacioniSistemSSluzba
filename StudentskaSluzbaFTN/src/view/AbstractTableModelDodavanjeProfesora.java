package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesori;

public class AbstractTableModelDodavanjeProfesora extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return BazaProfesori.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if(column == 0) 
			return BazaProfesori.getInstance().getProfesori().get(row).getImePrezimeProfesora();
		else return " ";
	}

}
