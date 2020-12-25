package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ProfesoriJtable;

public class TabbedPane extends JTabbedPane{
	
	StudentTable studentTable;
	private int index;
	
	public static TabbedPane instance = null;
	
	public static TabbedPane getInstance() {
		
		if (instance == null) {
			instance = new TabbedPane();
		}
		return instance;
	}
	
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
		
		ProfesoriJtable profesoriTable = new ProfesoriJtable();
		//profesoriTable.setAutoCreateRowSorter(true);
		JScrollPane spProfesor = new JScrollPane(profesoriTable);
		this.addTab("Profesor", spProfesor);
		
		this.addChangeListener(changeListener);
		
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) studentTable.getModel();

		model.fireTableDataChanged();
	}
	
	ChangeListener changeListener = new ChangeListener() {
		  public void stateChanged(ChangeEvent changeEvent) {
		    JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		    index = sourceTabbedPane.getSelectedIndex();
		    System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
		  }
		};
		
	public int getIndex() {
		return index;
	}

}
