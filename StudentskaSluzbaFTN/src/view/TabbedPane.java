package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane{
	
	public TabbedPane() {
		super();
		JPanel panelStudent = new JPanel();
		JPanel panelProfesor = new JPanel();
		this.addTab("Student", panelStudent);
		this.addTab("Profesor", panelProfesor);
	}

}
