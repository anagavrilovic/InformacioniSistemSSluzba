package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import main.Main;

public class ProfesorTable extends JTable{
	
	
	
	public ProfesorTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.setGridColor(Color.LIGHT_GRAY);
		this.setAutoCreateRowSorter(true);
		this.setRowHeight(25);
		this.setIntercellSpacing(new Dimension(15, 4));
		
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		Main.changeFont(this, f);
		
		this.getTableHeader().setBackground(new Color(90, 216, 252));
		this.getTableHeader().setForeground(Color.WHITE);
		this.getTableHeader().setPreferredSize(new Dimension(0, 28));
		this.getTableHeader().setReorderingAllowed(false);
		
		this.setModel(new AbstractTableModelProfesori());
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
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
