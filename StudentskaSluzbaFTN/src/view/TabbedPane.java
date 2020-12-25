package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class TabbedPane extends JTabbedPane{
	
	StudentTable studentTable;
	
	public TabbedPane() {
		super();
		
		Font font = new Font("sans-serif", Font.BOLD, 12);
		this.setFont(font);
		
		this.setBackground(new Color(90, 216, 252));
		this.setForeground(Color.WHITE);
		
		studentTable = new StudentTable();
		JScrollPane spStudent = new JScrollPane(studentTable);
		this.addTab("Student", spStudent);
		azurirajPrikaz(null, -1);
		
		JPanel panelProfesor = new JPanel();
		this.addTab("Profesor", panelProfesor);
		
		
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) studentTable.getModel();

		model.fireTableDataChanged();
		validate();
	}

}
