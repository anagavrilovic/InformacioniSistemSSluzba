package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Student> studenti;
	private List<Profesor> profesori;
	private List<Predmet> predmeti;
	
	public Data() {
		
		this.studenti = BazaStudenti.getInstance().getStudentList();
		this.profesori = BazaProfesori.getInstance().getProfesori();
		this.predmeti = BazaPredmeti.getInstance().getPredmeti();
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
}
