package model;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetiTable extends JTable{
	
	public PredmetiTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Sama JTable komponenta je implementirana postujuci MVC arhitekturu.
		this.setModel(new AbstractTableModelPredmeti());
		this.setAutoCreateRowSorter(true); 
	} 

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		// Svaka celija ima renderer, koji se poziva prilikom njenog iscrtavanja.
		// Podrazumevano se pozivaju prilikom inicijalnog iscrtavanja tabele.
		// Ukoliko korisnik selektuje neku celiju, dolazi do ponovnog
		// iscrtavanje svih celija u redu koji je selektovan, kao i u redu
		// koji je prethodno bio selektovan.
		// System.out.println(row + " " + column);
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
