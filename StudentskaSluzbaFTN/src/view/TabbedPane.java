package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;


public class TabbedPane extends JTabbedPane{
	
	private StudentTable studentTable;
	private ProfesorTable profesorTable;
	private PredmetTable predmetTable;
	private int index;
	
	public static TabbedPane instance = null;
	
	public static TabbedPane getInstance() {
		
		if (instance == null) {
			instance = new TabbedPane();
		}
		return instance;
	}
	
	private TabbedPane() {
		super();

		Font font = new Font("sans-serif", Font.BOLD, 12);
		this.setFont(font);
		
		this.setBackground(new Color(90, 216, 252));
		this.setForeground(Color.WHITE);
		
		AbstractTableModelStudenti atmStud = new AbstractTableModelStudenti();
		studentTable = new StudentTable(atmStud);
		JScrollPane spStudent = new JScrollPane(studentTable);
		this.addTab("Student", spStudent);
		BazaStudenti.getInstance().izaberiSve();
		azurirajPrikazStudent(null, -1);
		
		AbstractTableModelProfesori atmProf = new AbstractTableModelProfesori();
		profesorTable = new ProfesorTable(atmProf);
		JScrollPane spProfesor = new JScrollPane(profesorTable);
		this.addTab("Profesor", spProfesor);
		azurirajPrikazProf(null, -1);
		
		AbstractTableModelPredmeti atmPred = new AbstractTableModelPredmeti();
		predmetTable = new PredmetTable(atmPred);
		JScrollPane spPredmet = new JScrollPane(predmetTable);
		this.addTab("Predmet", spPredmet);
		azurirajPrikazPredmet(null, -1);
		
		this.addChangeListener(changeListener);
		
	}
	
	public void azurirajPrikazStudent(String akcija, int vrednost) {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) studentTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazProf(String akcija, int vrednost) {
		AbstractTableModelProfesori modelProf = (AbstractTableModelProfesori) profesorTable.getModel();
		modelProf.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazPredmet(String akcija, int vrednost) {
		AbstractTableModelPredmeti modelPredm = (AbstractTableModelPredmeti) predmetTable.getModel();
		modelPredm.fireTableDataChanged();
		validate();
	}
	
	// Preuzeto sa sajta: http://www.java2s.com/Tutorial/Java/0240__Swing/ListeningforSelectedTabChanges.htm
	ChangeListener changeListener = new ChangeListener() {
		  public void stateChanged(ChangeEvent changeEvent) {
		    JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		    int index = sourceTabbedPane.getSelectedIndex();
		    TabbedPane.getInstance().setIndex(index);
		  }
		};
		
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	

	public String getIndexFromSelectedRow() {
		int row = studentTable.getSelectedRow();
		
		if(row != -1) {
			return (String) studentTable.getValueAt(row, 0);
		} else {
			return "";
		}
	}
	
	public String getSifraPredFromSelectedRow() {
		int row = predmetTable.getSelectedRow();
		
		if(row != -1) {
			return (String) predmetTable.getValueAt(row, 0);
		} else {
			return "";
		}
	}

	public String nadjiKlljuc() {
		int red = profesorTable.getSelectedRow();
		
		if(red != -1) {
			//return (String) BazaProfesori.getInstance().getValueAt(red, 4);
			return (String) profesorTable.getValueAt(red, 4);
		}
		else
			return "";
	}

	public StudentTable getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(StudentTable studentTable) {
		this.studentTable = studentTable;

	}

	public ProfesorTable getProfesorTable() {
		return profesorTable;
	}

	public void setProfesorTable(ProfesorTable profesorTable) {
		this.profesorTable = profesorTable;
	}

	public PredmetTable getPredmetTable() {
		return predmetTable;
	}

	public void setPredmetTable(PredmetTable predmetTable) {
		this.predmetTable = predmetTable;
	}
}
