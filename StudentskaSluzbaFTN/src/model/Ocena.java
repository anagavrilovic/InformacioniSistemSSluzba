package model;

import java.util.Date;

public class Ocena {
	private Student student;
	private Predmet predmet;
	private int ocena;
	private Date datum;
	
	
	public Ocena() {
		super();
		this.student = new Student();
		this.predmet = new Predmet();
		this.ocena = 0;
		this.datum = new Date();
	}
	
	public Ocena(Student student, Predmet predmet, int ocena, Date datum) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datum = datum;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Ocena [ocena=" + ocena + ", datum=" + datum + "]";
	}
	
	
	
}
