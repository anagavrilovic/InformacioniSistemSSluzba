package view;


import javax.swing.table.AbstractTableModel;
import model.BazaStudenti;


public class AbstractTableModelDodavanjePredmeta extends AbstractTableModel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String index;

	public AbstractTableModelDodavanjePredmeta(String index) {
		this.index = index;
	}
	
	@Override
	public int getColumnCount() {
		return BazaStudenti.getInstance().pronadjiStudenta(index).getColumnCountDodavanje();
	}

	@Override
	public int getRowCount() {
		if(!(BazaStudenti.getInstance().pronadjiStudenta(index).getListaPredZaDodavanje() == null))
			return BazaStudenti.getInstance().pronadjiStudenta(index).getListaPredZaDodavanje().size();
		else
			return -1;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaStudenti.getInstance().pronadjiStudenta(index).getValueAtPredDodavanje(row, column);
	}

}
