package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import model.ProfesoriJtable;

public class TabbedPane extends JTabbedPane{
	
	public TabbedPane() {
		super();
		
		ProfesoriJtable profesoriTable = new ProfesoriJtable();
		//profesoriTable.setAutoCreateRowSorter(true);
		JScrollPane spProfesor = new JScrollPane(profesoriTable);
		this.addTab("Profesor", spProfesor);
	}

}
